package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopoSortDFS {
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
        int[] ans = new int[V];
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,stack,vis,adj);
            }
        }
        int i=0;
        while(!stack.isEmpty()){
            ans[i++]=stack.peek();
            stack.pop();
        }
        return ans;
    }

    static void dfs(int index,Stack<Integer> stack,boolean[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[index]=true;
        stack.push(index);
        for(Integer nei : adj.get(index)){
            if(!vis[nei]){
                dfs(nei,stack,vis,adj);
            }
        }
    }

}

//Time Complexity: O(V+E)+O(V), where V = no. of nodes and E = no. of edges. There can be at most V components. So, another O(V) time complexity.
//Space Complexity: O(2N) + O(N) ~ O(2N): O(2N) for the visited array and the stack carried during DFS calls and O(N) for recursive stack space, where N = no. of nodes.
