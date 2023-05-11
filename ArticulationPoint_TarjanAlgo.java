import java.util.*;

public class ArticulationPoint_TarjanAlgo {
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
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,4));
        graph[4].add(new Edge(4,3));
    }
    public static void dfs( ArrayList<Edge>graph[],int discoveryTime[], int lowestDiscoveryTime[], boolean visi[]
    ,boolean ap [],int curr,int par,int time){
        visi[curr]= true;
        discoveryTime[curr]=lowestDiscoveryTime[curr]= ++time;
        int child =0;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if(par== neigh){
                continue;
            }
            else if(!visi[neigh]){
                dfs(graph, discoveryTime, lowestDiscoveryTime, visi, ap, neigh, curr, time);
                lowestDiscoveryTime[curr]= Math.min(lowestDiscoveryTime[curr], lowestDiscoveryTime[neigh]);
                if(par!=-1 && discoveryTime[curr]<=lowestDiscoveryTime[neigh]){
                  //  System.out.print(curr);
                    ap[curr]= true;
                }
                child++;
            }
            else{
                lowestDiscoveryTime[curr]= Math.min(lowestDiscoveryTime[curr],discoveryTime[neigh]);
            }
        }
        if(par==-1 && child>1){
            ap[curr]= true;
        }

    }
    public static void findAP(ArrayList<Edge>graph[],int v){
     boolean ap []= new boolean[v];
     int discoveryTime[] = new int[v];
     int lowestDiscoveryTime[] = new int[v];
     boolean visi[]= new boolean[v];
     int time =0;
     for(int i=0;i<v;i++){
     if(!visi[i]){
    dfs(graph,discoveryTime, lowestDiscoveryTime, visi, ap, i,-1, time);
      }
     }
     for(int i=0;i<v;i++){
        if(ap[i]){
            System.out.println(" Ap = "+i);
        }
     }
    }
    public static void main(String args[]){
        int v=6;
        ArrayList<Edge>graph[]= new ArrayList[v];
        createGraph(graph);
        findAP(graph, v);
    }
}
