import java.util.*;
public class CheapFlight_with_K_Stops{
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public static void createGraph(  ArrayList<Edge>graph [],int flights[][]){
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }
        for(int i=0;i<flights.length;i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];
            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }
    static class Info{
        int v;
        int cost;
        int stop;
        public Info(int v, int cost,int stop){
            this.v= v;
            this.cost= cost;
            this.stop= stop;
        }
    }
    public static int cheapFlight(int flights[][],int n,int src,int dest, int stops){
        ArrayList<Edge>graph [] = new ArrayList[n];
        boolean visited[]= new boolean[n];
            createGraph(graph, flights);

        int dist[]= new int[graph.length];
        for(int i=0; i< dist.length; i++){
            if(i!= src){
                dist[i]= Integer.MAX_VALUE;
            }
        }
       Queue<Info>q = new LinkedList<>();     
             q.add(new Info(src, 0, 0));      
             while(!q.isEmpty()){
                Info curr = q.remove();
                 if(curr.stop>stops){
                     break;
                 }
                 if(!visited[curr.v]){
                    visited[curr.v]=true;
                    for(int i=0; i< graph[curr.v].size(); i++){
                   Edge e = graph[curr.v].get(i);
                   int u = e.src;
                   int v = e.dest;
                   int wt = e.wt;
                   if(curr.cost+wt<dist[v] && curr.stop<=stops){
                    dist[v]=curr.cost+wt;
                    q.add(new Info(v,dist[v] , curr.stop+1));
                   }
                    }
                 }

             } 
             if(dist[dest]==Integer.MAX_VALUE){
                return -1;
             }
             else {
                return dist[dest];
             }
        
    }
    public static void main(String args[]){
        int flights[][] = {{0,1,100},{1,2,100},{1,3,600},{2,3,200}};
        int n =4;
        int src=0;
        int dest = 3;
        int k=1;
        System.out.println(cheapFlight(flights,n,src,dest,k));
    }

}