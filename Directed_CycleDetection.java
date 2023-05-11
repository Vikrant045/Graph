import java.util.*;
public class Directed_CycleDetection {
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
    public static void createGraph(ArrayList<Edge>[]graph){
            for(int i=0;i<graph.length;i++){
                graph[i]= new  ArrayList<>();
            }
           // graph[0].add(new Edge(0,2,1));

            graph[1].add(new Edge(1,0,1));
            graph[3].add(new Edge(3,0,1));
            graph[3].add(new Edge(3,2,1));

            graph[2].add(new Edge(2,0,1));
    }
    public static boolean isCycle(  ArrayList<Edge>[]graph){
        boolean stack[]= new boolean[graph.length];
        boolean visited[]= new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                if(isCycleUtil(graph,i,visited,stack)){
                    return true;
                }
            }
        }
        return false;

    }
    public static boolean isCycleUtil(ArrayList<Edge>[]graph,int curr,boolean visited[],boolean stack[]){
    visited[curr]= true;
    stack[curr]= true;
             
            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                if(stack[e.dest]){
                    return true;
                }
                if(!visited[e.dest] && isCycleUtil(graph, e.dest, visited, stack)){
                    return true;
                }
            }
            stack[curr]= false;
            return false;

    }
    public static void main(String args[]){
        ArrayList<Edge>[]graph = new ArrayList[4];
        createGraph(graph);
        System.out.println(isCycle(graph));
    }
    
}
