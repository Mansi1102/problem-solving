package String;

public class ValidAnagram {
    public static void  main(String[] args) {
        String s1 = "rac";
        String s2 = "car";
        System.out.println("Valid Anagram: " + isAnagram(s1,s2));
    }

    static boolean isAnagram(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        int counter[] = new int[26];
        for(int i=0;i<s1.length();i++){
            counter[s1.charAt(i) - 'a']++;
            counter[s2.charAt(i) - 'a']--;
        }

        for(int count: counter){
            if(count!=0){
                return false;
            }
        }
        return true;

    }
}
