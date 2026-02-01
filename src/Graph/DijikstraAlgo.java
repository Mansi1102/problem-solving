package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijikstraAlgo {
    public static void main(String[] args){
            int V = 3, E=3,S=2;
            ArrayList<Integer> node1 = new ArrayList<>() {{add(1);add(1);}};
            ArrayList<Integer> node2 = new ArrayList<>() {{add(2);add(6);}};
            ArrayList<Integer> node3 = new ArrayList<>() {{add(2);add(3);}};
            ArrayList<Integer> node4 = new ArrayList<>() {{add(0);add(1);}};
            ArrayList<Integer> node5 = new ArrayList<>() {{add(1);add(3);}};
            ArrayList<Integer> node6 = new ArrayList<>() {{add(0);add(6);}};

            ArrayList<ArrayList<Integer>> inter1 = new ArrayList<>(){
                {
                    add(node1);
                    add(node2);
                }
            };
            ArrayList<ArrayList<Integer>> inter2 = new ArrayList<>(){
                {
                    add(node3);
                    add(node4);
                }
            };
            ArrayList<ArrayList<Integer>> inter3 = new ArrayList<>(){
                {
                    add(node5);
                    add(node6);
                }
            };
            ArrayList<ArrayList<ArrayList<Integer>>> adj= new ArrayList<>(){
                {
                    add(inter1); // for 1st node
                    add(inter2); // for 2nd node
                    add(inter3); // for 3rd node
                }
            };

            int[] res= dijkstra(V,adj,S);

            for(int i=0;i<V;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
    }


    static int[] dijkstra(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj,int s){
        PriorityQueue<distancePair> pq = new PriorityQueue<distancePair>((x,y)->x.distance - y.distance);
        int[] distanceNode = new int[V];
        Arrays.fill(distanceNode, (int) (1e9));
        distanceNode[s]=0;
        pq.add(new distancePair(0,s));
        while(!pq.isEmpty()){
            int d = pq.peek().distance;
            int n = pq.peek().node;
            pq.poll();
            for(ArrayList<Integer> it: adj.get(n)){
                int weight = it.get(1);
                int adjNode = it.get(0);
//            for(int i=0;i<adj.get(n).size();i++){
//                int weight = adj.get(n).get(i).get(1);
//                int adjNode = adj.get(n).get(i).get(0);

                if(d+weight<distanceNode[adjNode]){
                    distanceNode[adjNode] = d+weight;
                    pq.add(new distancePair(distanceNode[adjNode],adjNode));
                }

            }
        }
        return  distanceNode;
    }

}

 class distancePair{
    int distance;
    int node;

    distancePair(int distance,int node){
        this.distance=distance;
        this.node=node;
    }
 }
