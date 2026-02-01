package String;

import java.util.HashMap;

public class LongestSubstringWithOutRepeatingCharacter {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Length Of Longest Substring: " + lengthOfLongestSubstring(s));
    }
    private static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right =0;
        int n = s.length();
        int len =0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(right<n){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right))+1,left);
            }
            map.put(s.charAt(right),right);
            len = Math.max(len,right-left+1);
            right++;
        }
        return len;
    }
}

/*
Used sliding window + 2 pointer

T.C - o(n)
S.C - 0(n)
 */
