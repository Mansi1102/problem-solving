// Breadth First Search (BFS): Level Order Traversal
package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BfsTraversal {
// Function to return Breadth First Traversal of the graph
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                visited[i] = true;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                while(!queue.isEmpty()){
                    Integer node = queue.poll();
                    bfs.add(node);
                    for(Integer itr: adj.get(node)){
                        if(!visited[itr]){
                            visited[itr] = true;
                            queue.add(itr);
                        }
                    }
                }
            }
        }
        return bfs;
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<5;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        BfsTraversal bfs = new BfsTraversal();
        ArrayList<Integer> result = bfs.bfsOfGraph(5, adj);
        System.out.println("BFS Traversal: " + result);
    }
}

// Output: BFS Traversal: [0, 1, 4, 2, 3]
//Time Complexity: O(N) + O(2E), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes.
//Space Complexity: O(3N) ~ O(N), Space for queue data structure visited array and an adjacency list