import java.util.*;
public class BFS_Traversal{
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src= src;
            this.dest= dest;
            this.wt= wt;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph){

        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 5));  // vtx 0
        graph[1].add(new Edge(1, 0, 5)); //vtx 1
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        graph[2].add(new Edge(2, 1, 1));  //vtx 2
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));
        graph[3].add(new Edge(3, 1, 3)); //vtx 3
        graph[3].add(new Edge(3, 2, 1));
        graph[4].add(new Edge(4, 2, 2));  // vtx 4
    }
    public static void bfs(ArrayList<Edge>[]graph){
        Queue<Integer> q = new LinkedList<Integer>();
               boolean visited[]= new boolean[graph.length];
               q.add(0);
               while(!q.isEmpty()){
                int curr = q.remove();
                if(visited[curr]!=true){
                    System.out.println(curr+" ");
                    visited[curr]= true;
                    for(int i=0;i<graph[curr].size();i++){
                        Edge e = graph[curr].get(i);
                        if(!visited[e.dest]==true){
                        q.add(e.dest);
                    }
                }
                }
               }
    }

    public static void main(String args[]){

        int v=5;
        ArrayList<Edge>graph[]=new ArrayList[v];
        createGraph(graph);
        bfs(graph);

    }

}