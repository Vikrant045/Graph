import java.util.*;
public class DFS {
    
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
    public static void dfs ( ArrayList<Edge>graph[],int curr,boolean visited[]){

        System.out.print(curr+" ");
        visited[curr]= true;

        for(int i=0;i<graph[curr].size();i++){
              Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(graph, e.dest, visited);
            }
        }
    }
    public static void main(String args[]){
        int v=7;
        ArrayList<Edge>graph[]=new ArrayList[v];
        createGraph(graph);
        dfs(graph, 0, new boolean[v]);

    }
}
