import java.util.*;
public class Tarjan_Bridge_Algo {
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
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,0));
        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,5));
        graph[3].add(new Edge(3,4));
        graph[4].add(new Edge(4,5));
        graph[4].add(new Edge(4,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,3));

    }
    public static void dfs(ArrayList<Edge> []graph, int discoveryTime[],int lowestDiscoveryTime[],
    boolean visi [], int time, int curr,int par){
        visi[curr]= true;
        discoveryTime[curr]= lowestDiscoveryTime[curr]=++time;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(e.dest==par){
                continue;
            }
           else if(!visi[e.dest]){
                dfs(graph, discoveryTime, lowestDiscoveryTime, visi, time, e.dest, curr);
                lowestDiscoveryTime[curr]= Math.min(lowestDiscoveryTime[curr], lowestDiscoveryTime[e.dest]);
                     if(discoveryTime[curr]<lowestDiscoveryTime[e.dest]){
                        System.out.println("Bridge "+curr+"---"+e.dest);
                     }
            }
            else{
                lowestDiscoveryTime[curr]= Math.min(lowestDiscoveryTime[curr], discoveryTime[e.dest]);
            }
        }

    }
    public static void   tarjanBridge(ArrayList<Edge> []graph,int v){
        int discoveryTime[]= new int[v];
        int lowestDiscoveryTime[]= new int [v];
        boolean visi []= new boolean[v];
        int time =0;
        for(int i=0;i<v;i++){
            if(!visi[i]){
             dfs(graph, discoveryTime, lowestDiscoveryTime, visi, time, i,-1);
            }
        }
    }
    public static void main(String args[]){
        int v=6;
        ArrayList<Edge>graph[]= new ArrayList[v];
        createGraph(graph);
        tarjanBridge(graph,v);

    }
    
}
