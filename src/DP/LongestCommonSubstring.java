package DP;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String text1 ="acd";
        String text2 ="ced";
        System.out.println("Longest Common Substring: " + longestCommonSubstring(text1, text2));
    }
    private static int longestCommonSubstring(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        int ans =0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                    ans=Math.max(ans,dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
