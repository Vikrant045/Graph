import java.util.*;
public class ConnectedGraph {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src = src;
            this.dest = dest;
            this.wt= wt;
        }
    }
    public static void  bfs(ArrayList<Edge>graph[] ){
        boolean visi[]= new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!visi[i]){
                bfs_util(graph, visi);
            }
        }
    }

    public static void  bfs_util(ArrayList<Edge>graph[],boolean visi[] ){
               Queue <Integer> q= new LinkedList<>();
               
               q.add(0);
               while(!q.isEmpty()){
                int curr = q.remove();
               if(!visi[curr]){
                visi[curr]= true;
                System.out.println(curr);
                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
               }
            }
    }
    public static void dfs_util(ArrayList<Edge>graph[] ){
boolean visi []= new boolean [graph.length];
        
     for(int i=0;i<graph.length;i++){
   
        dfs_util(graph, i, visi);
    
       }
    }
    public static void dfs_util(ArrayList<Edge>graph[],int curr, boolean visi[] ){
        System.out.println(curr);
        visi[curr]= true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visi[e.dest])
            dfs_util(graph, e.dest, visi);
        }
    }

    public static void createGraph(ArrayList<Edge>[]graph){

        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 5));  // vtx 0
        graph[0].add(new Edge(0, 2, 5));

        graph[1].add(new Edge(1, 0, 5)); //vtx 1
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));  //vtx 2
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 3)); //vtx 3
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 2));  // vtx 4
        graph[3].add(new Edge(4, 3, 1));
        graph[3].add(new Edge(4, 5, 1));

        graph[3].add(new Edge(5, 6, 1)); //vtx 5



    }
    public static void main(String args[]){
        int v=7;
        ArrayList<Edge>graph[]=new ArrayList[v];
        createGraph(graph);
        bfs(graph);
    }
    
}
