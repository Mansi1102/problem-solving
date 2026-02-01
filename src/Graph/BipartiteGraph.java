package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public static void main(String[] args){
        int[][] graph = {
                {1,2,3},
                {0,2},
                {0,1,3},
                {0,2}
        };

        System.out.println("Is this Graph bipartite " + isBipartite(graph));
    }

    static boolean isBipartite(int[][] graph){
        int n = graph.length;
        int[] color = new int [n];
        Arrays.fill(color, -1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(check(i, color, graph)){
                    return true;
                }
            }
        }
        return  false;
    }

    static boolean check(int index, int color[], int[][] adj){
        color[index]=0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        while (!queue.isEmpty()){
            int cur = queue.peek();
            queue.remove();
            for (Integer itr: adj[cur]){
                if(color[itr]==-1){
                    color[itr]=1-color[cur];
                    queue.add(itr);
                }
                else  if(color[itr]==color[cur]){
                    return  false;
                }
            }
        }
        return true;
    }
}

// Using DFS

/*

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int [n];
        Arrays.fill(color, -1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!checkDFS(i, color, graph)){
                    return false;
                }
            }
        }
        return  true;
    }

       static boolean checkDFS(int index, int color[], int[][] adj){
        if(color[index]==-1){
         color[index]=0;
        }
        for (Integer itr: adj[index]){
            if(color[itr]==-1){
                color[itr]=1-color[index];
                 if(!checkDFS(itr, color, adj)){
                    return false;
                }
            }
                else  if(color[itr]==color[index]){
                    return  false;
                }
            }
        return true;
    }
}
 */

// T.C = 0(N+2E)
// SC = 0(N)
