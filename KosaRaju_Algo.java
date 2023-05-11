import java.util.*;
public class KosaRaju_Algo {
    static class Edge{
        int src;
        int dest;
        public Edge(int s, int dest){
            this.src= s;
            this.dest = dest;
        }
    }
    public static void createGraph( ArrayList<Edge>graph[],int v){
        for(int i=0;i<v;i++){
            graph[i]= new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }
    public static void topsort(ArrayList<Edge>graph[],boolean visi[], Stack<Integer> s,int curr){
        visi[curr]= true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visi[e.dest]){
                topsort(graph, visi, s, e.dest);
            }
        }
        s.push(curr);
    }
    public static void dfs(ArrayList<Edge>graph[],boolean visi[],int curr){
        visi[curr]= true;
        System.out.print(" "+curr);
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visi[e.dest]){
                dfs(graph, visi, e.dest);
            }
        }
    }
    public static void kosaRaju(  ArrayList<Edge>graph[],int v){
        boolean visi[]= new boolean[v];
        Stack<Integer> s = new Stack<>();
        // step1  topsort
        for(int i=0;i<v;i++){
            if(!visi[i]){
                topsort(graph,visi,s,i);
            }
        }

        // step2 transpose graph
        ArrayList<Edge>transpose[]= new ArrayList[v];
        for(int i=0;i<graph.length;i++){
            transpose[i]= new ArrayList<Edge>();
            visi[i]= false;
        }
        for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].size();i++){
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }
        // step 3 

        while(!s.isEmpty()){
            int curr = s.pop();
            if(!visi[curr]){
                System.out.print("scc ->");
                dfs(transpose,visi,curr);
                System.out.println();
            }
           

        }


    }
    public static void main(String args[]){
        int v=5;
        ArrayList<Edge>graph[]= new ArrayList[v];
        createGraph(graph,v);
        kosaRaju(graph, v);
    }
    
}
