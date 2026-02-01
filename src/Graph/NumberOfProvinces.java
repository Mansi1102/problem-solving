// Description: This code finds the number of provinces (connected components) in a given undirected graph represented by an adjacency matrix.
// Use DFS to traverse the graph and count the number of connected components.
// Convert the adjacency matrix to an adjacency list for easier traversal.
package Graph;

import java.util.ArrayList;

public class NumberOfProvinces {

    public static int findCircleNum(int[][] isConnected){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        int m = isConnected[0].length;
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i); // Since the graph is undirected
                }
            }
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i, visited, adj);
            }
        }
        return count;
    }

    public static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        for(Integer itr : adj.get(node)) {
            if(!visited[itr]) {
                dfs(itr, visited, adj);
            }
        }
    }

    public static void main(String[] args){
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        System.out.println("Number of Provinces: " + findCircleNum(isConnected));
    }
}

// Output: Number of Provinces: 2
// Time Complexity: O(N) + O(V+2E), Where O(N) is for outer loop and inner loop runs in total a single DFS over entire graph, and we know DFS takes a time of O(V+2E).
//Space Complexity: O(N) + O(N),Space for recursion stack space and visited array.
