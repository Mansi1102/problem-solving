// Depth First Search (DFS)
package Graph;

import java.util.ArrayList;

public class DfsTraversal {
    // Function to return Depth First Traversal of the graph
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsTraversal(i, V, visited, adj,dfs);
            }
        }
        return dfs;
    }

    public static void dfsTraversal(int node, int V, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs) {
        visited[node] = true;
        dfs.add(node);
        for (Integer itr : adj.get(node)) {
            if (!visited[itr]) {
                dfsTraversal(itr, V, visited, adj,dfs);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        DfsTraversal dfs = new DfsTraversal();
                ArrayList<Integer> result = dfs.dfsOfGraph(5, adj);
                System.out.println("DFS Traversal: " + result);
            }
}

// Output: DFS Traversal: [0, 2, 4, 1, 3]
//Time Complexity: For an undirected graph, O(N) + O(2E), For a directed graph, O(N) + O(E), Because for every node we are calling the recursive function once, the time taken is O(N) and 2E is for total degrees as we traverse for all adjacent nodes.
//Space Complexity: O(3N) ~ O(N), Space for dfs stack space, visited array and an adjacency list.ce Complexity: O(3N) ~ O(N), Space for queue data structure visited array and an adjacency list