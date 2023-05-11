import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bipartiteOrNot {
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
            graph[0].add(new Edge(0,1,1));
            graph[0].add(new Edge(0,2,1));

            graph[1].add(new Edge(1,0,1));
            graph[1].add(new Edge(1,3,1));
            graph[3].add(new Edge(3,1,1));
            graph[3].add(new Edge(3,2,1));
        
            graph[2].add(new Edge(2,0,1));
            graph[2].add(new Edge(2,3,1));
    }
   
    public static boolean bipartite(ArrayList<Edge>[]graph){
        int col[]= new int[graph.length];
        for(int i=0;i<graph.length;i++){
           col[i]=-1;
           }
           Queue<Integer>q = new LinkedList<>();

           for(int i=0;i<graph.length;i++){
                          if(col[i]==-1){
                            q.add(i);
                            col[i]=0;
                            while(!q.isEmpty()){
                                int curr = q.remove();
                                for(int j=0;j<graph[curr].size();j++){
                                    Edge e = graph[curr].get(j);
                                    if(col[e.dest]==-1){
                                        int nextcol = col[curr]==0?1:0;
                                        col[e.dest]= nextcol;
                                        q.add(e.dest);
                                    }
                                    else if(col[e.dest]== col[curr]){
                                        return false;
                                    }
                                }
                            }

                          }
           }
           return true;
       
    }
    
    public static void main(String args[]){
        ArrayList<Edge>[]graph = new ArrayList[5];
        createGraph(graph);
System.out.println(bipartite(graph));
    }
}

