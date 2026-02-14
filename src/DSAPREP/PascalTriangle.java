package DSAPREP;
import java.util.*;
public class PascalTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> result = generate(numRows);
        System.out.println(result);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> rows = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j==0 || j==i) {
                    rows.add(1);
                } else {
                    rows.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(rows);
        }
        return result;
    }
}
