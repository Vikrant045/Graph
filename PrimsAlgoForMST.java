import java.util.*;
public class PrimsAlgoForMST {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge (int src,int dest,int wt){
            this.src= src;
            this.dest= dest;
            this.wt = wt;
        }
    }
    static class Pair implements Comparable<Pair>{
        int v ;
        int cost;
        public Pair(int v,int c){
            this.v=v;
            this.cost=c;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }
    public static void createGraph(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));

        graph[2].add(new Edge(2,3,50));
        graph[2].add(new Edge(2,0,15));
    }
    public static void prims(ArrayList<Edge>graph[]){
boolean visited[]= new boolean[graph.length];
PriorityQueue <Pair>pq = new PriorityQueue<>();
int finalcost = 0;
          pq.add(new Pair(0, 0));
          while(!pq.isEmpty()){
            Pair curr =  pq.remove();
            if(!visited[curr.v]){
                visited[curr.v]= true;
                finalcost+=curr.cost;
                for(int i=0;i<graph[curr.v].size();i++){
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }

            }
          }
          System.out.println(finalcost);
    }

    public static void main(String args[]){
        int v=4;
        ArrayList<Edge>graph[] = new ArrayList[v];
        createGraph(graph);
        prims(graph);

    }
    
}
