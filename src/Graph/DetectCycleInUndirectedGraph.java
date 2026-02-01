package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Using BFS
public class DetectCycleInUndirectedGraph {
    public static void main(String[] args){
        int V = 8, E = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=V;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(4);
        adj.get(4).add(2);
        adj.get(3).add(5);
        adj.get(5).add(3);
        adj.get(4).add(6);
        adj.get(6).add(4);
        adj.get(5).add(7);
        adj.get(7).add(5);
        adj.get(6).add(8);
        adj.get(8).add(6);
        adj.get(7).add(8);
        adj.get(8).add(7);

        System.out.println("Contains Cycle: " + isCycle(V,adj));
    }

    static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(checkForCycle(i,V,vis,adj)){
                    return true;
                }
            }
        }
        return  false;
    }

    static boolean checkForCycle(int src, int V, boolean vis[], ArrayList<ArrayList<Integer>> adj){
        vis[src] = true;
        Queue<CyclePair> q = new LinkedList<>();
        q.add(new CyclePair(src,-1));
        while(!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();
            for(Integer itr: adj.get(node)){
                if(!vis[itr]){
                    vis[itr]=true;
                    q.add(new CyclePair(itr,node));
                }
                else if(parent!=node){
                    return true;
                }
            }
        }
        return  false;
    }
}

  class CyclePair{
    int first;
    int second;

      CyclePair(int first, int second){
        this.first = first;
        this.second = second;
    }
  }

 // Time Complexity = 0(N+2E) + 0(N)
// Space Complexity = 0(N)


// Using DFS
/*
    private boolean dfs(int node, int parent, int vis[], ArrayList<ArrayList<Integer>>
    adj) {
        vis[node] = 1;
        // go to all adjacent nodes
        for(int adjacentNode: adj.get(node)) {
            if(vis[adjacentNode]==0) {
                if(dfs(adjacentNode, node, vis, adj) == true)
                    return true;
            }
            // if adjacent node is visited and is not its own parent node
            else if(adjacentNode != parent) return true;
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       int vis[] = new int[V];
       for(int i = 0;i<V;i++) {
           if(vis[i] == 0) {
               if(dfs(i, -1, vis, adj) == true) return true;
           }
       }
       return false;
    }
 */

// Time Complexity: O(N + 2E) + O(N)
//Space Complexity: O(N) + O(N) ~ O(N), Space for recursive stack space and visited array.
