import java.util.*;
public class MotherVertex {
    static class Edge{
        int src;
        int dest;
      
        public Edge (int src,int dest){
            this.src= src;
            this.dest= dest;
           
        }
    }
    public static void createGraph(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,4));
    }
    public static void dfs(ArrayList<Edge>graph[],  boolean visi[],Stack<Integer> s,int curr){

         visi[curr]= true;
         for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visi[e.dest]){
                dfs(graph, visi, s, e.dest);
            }
            s.push(curr);
         }
    }
    public static void motherV(ArrayList<Edge>graph[],int v){
        boolean visi[]=new boolean[v];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<v;i++){
            if(!visi[i]){
                dfs(graph, visi, s,i);
            }
        }
        int o = s.peek();
        for(int i=0;i<v;i++){
           visi[i]= false;
         
        }

        dfs(graph, visi, s, o);
        for(int i=0;i<v;i++){
            if(!visi[i]){
                System.out.println(" No Mother vertex");
            }
            else{
                System.out.println("mother v exists");
            }
         }
    }
    public static void main(String args[]){
        int v=5;
        ArrayList<Edge>graph[]= new ArrayList[v];
        createGraph(graph);
        motherV(graph, v);
       
    }
    
}
