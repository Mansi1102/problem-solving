package Array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println("Pascal Triangle: " +generate(numRows));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prev=null;
        List<Integer> temp;
        for(int i=0;i<numRows;i++){
            temp = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    temp.add(1);
                }
                else{
                    temp.add(prev.get(j-1)+prev.get(j));
                }
            }
            prev=temp;
            res.add(temp);
        }
        return res;
    }
}
