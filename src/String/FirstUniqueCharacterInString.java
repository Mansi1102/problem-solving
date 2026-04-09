package String;

import java.util.HashMap;

public class FirstUniqueCharacterInString {
    public static void  main(String[] args) {
        String s = "leetcode";
        System.out.println("firstUniqChar: " + firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1) return i;
        }
        return -1;
    }
}
