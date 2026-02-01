package String;

public class SuperReducedString {
    public static void main(String[] args) {
        String str = "aaabccddd";
        String res = reduceString(str);
        System.out.println(res);
    }

    /*
    In Java, StringBuilder is a mutable sequence of characters.
    That means you can change (append, delete, insert, replace) the contents without creating a new object each time.
     */

    static  String reduceString(String str){
        StringBuilder result = new StringBuilder();

        for(char ch : str.toCharArray()){
            int len = result.length();
            if(len>0 && result.charAt(len-1)==ch){  // remove last char if it matches current one
                result.deleteCharAt(len-1);
            }
            else {
                result.append(ch);
            }
        }

        return result.length()==0?"Empty String":result.toString();
    }
}

// Output : abd
// Time complexity: o(n)
// Space cpmplexity: o(n)