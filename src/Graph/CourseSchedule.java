package Graph;

import java.util.ArrayList;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] preq: prerequisites){
            adj.get(preq[1]).add(preq[0]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] visPath = new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(dfs(i,vis,visPath,adj)){
                    return false;
                }
            }
        }
        return true;
    }

    static boolean dfs(int indx, boolean[] vis, boolean[] visPath, ArrayList<ArrayList<Integer>> adj){
        vis[indx] = true;
        visPath[indx] = true;

        for(int itr: adj.get(indx)){
            if(!vis[itr]){
                if(dfs(itr,vis,visPath,adj)){
                    return true;
                }
            }
            else if(visPath[itr]){
                return true;
            }
        }
        visPath[indx] = false;
        return false;
    }
}
