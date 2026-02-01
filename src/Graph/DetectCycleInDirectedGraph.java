package Graph;

import java.util.ArrayList;

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        System.out.println("Is Cycle:" + checkCycle(V, adj));
    }

    static  boolean checkCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[V];
        boolean[] visPath = new  boolean[V];
        for(int i =0;i<V;i++){
            if(!vis[i]){
                if(cycleDFS(i,vis,visPath,adj)){
                    return true;
                }
            }
        }
        return  false;
    }

    static boolean cycleDFS(int index, boolean[] vis, boolean[] visPath, ArrayList<ArrayList<Integer>> adj){
        vis[index] = true;
        visPath[index] = true;
        for(Integer nei : adj.get(index)){
           if(!vis[nei]){
               if(cycleDFS(nei,vis,visPath,adj)){
                   return  true;
               }
           }
           else if(visPath[nei]){
               return true;
           }
        }
        visPath[index] = false;
        return  false;
    }
    }

//Time Complexity: O(V+E)+O(V) , where V = no. of nodes and E = no. of edges. There can be at most V components. So, another O(V) time complexity.
//Space Complexity: O(2N) + O(N) ~ O(2N): O(2N) for two visited arrays and O(N) for recursive stack space.