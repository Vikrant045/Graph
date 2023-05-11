import java.util.*;
public class Creating_G_AdjacencyList{

    static class Edge{
        int src ;
        int des ;
        int wt;
        public Edge(int s,int d,int w){
            this.wt=w;
           this.src = s;
           this.des=d;
        }

    }
    public static void main(String args[]){
int v = 5;
         ArrayList<Edge> []graph= new ArrayList[v];
         for(int i=0;i<v;i++){
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


for(int i=0;i<graph[2].size();i++){
    Edge e = graph[2].get(i);
    System.out.println(e.des);
}



    }
}