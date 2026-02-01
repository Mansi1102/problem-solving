package Array;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int nums[] = {7,1,5,3,6,4};
        System.out.println("Best Time To Buy And Sell Stock: " + maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int pist = 0;
        int op =0;
        for(int i=0;i<prices.length;i++){
            if(prices[i] <= min){
                min = prices[i];
            }
            pist = prices[i] - min;
            if(pist>op){
                op = pist;
            }
        }
        return op;
    }
}

/*
Complexity Analysis

Time complexity: O(n)
Space Complexity: O(1)
 */
