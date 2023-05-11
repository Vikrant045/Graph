import java.beans.Visibility;
import java.util.*;
public class TopologicalSort {
    static class Edge{
        int src;
        int dest;
        public Edge (int src,int dest){
            this.src= src;
            this.dest= dest;
        }
        
    }
    public static void createGraph(ArrayList<Edge>[]graph){
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
    }
    public static void topSort(ArrayList<Edge>[]graph){
        boolean visi[]= new boolean[graph.length];
        Stack<Integer> s= new Stack<>();
        for(int i=0;i<graph.length;i++){
            if(!visi[i]){
                topSortUtil(graph,visi,s,i);
            }
        }
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }

    }
   public static void topSortUtil(ArrayList<Edge>[]graph,boolean []visi,Stack<Integer>s,int curr){
    visi[curr]= true;
    for(int i=0;i<graph[curr].size();i++){
        Edge e = graph[curr].get(i);
        if(!visi[e.dest]){
            topSortUtil(graph, visi, s, e.dest);
           
        }
    }
    s.push(curr);
   }
    public static void main(String args[]){
        int v=6;
        ArrayList<Edge>[]graph= new ArrayList[v];
        createGraph(graph);
        topSort(graph);
    }
    
}
