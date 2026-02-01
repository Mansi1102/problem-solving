package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TopoSortKahns {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        System.out.println("Topological Sort Using DFS: " + Arrays.toString(topoSort(V, adj)));
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        int ans[] = new int[V];
        int[] indegree = new int[V];
        // calculating indegree
        for(int i = 0; i < V; i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
            int i=0;
            while(!q.isEmpty()){
                int node = q.peek();
                ans[i++] = node;
                q.remove();
                for (Integer nei : adj.get(node)){
                    indegree[nei]--;
                    if(indegree[nei] == 0){
                        q.add(nei);
                    }
                }
            }
        return ans;
    }
}

//Time Complexity: O(V+E), where V = no. of nodes and E = no. of edges. This is a simple BFS algorithm.
//Space Complexity: O(N) + O(N) ~ O(2N), O(N) for the indegree array, and O(N) for the queue data structure used in BFS(where N = no.of nodes).
