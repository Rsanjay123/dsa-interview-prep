package DSAPREP;
import java.util.*;
public class pascalTriangle2 {
    public static void main(String[] args) {
        int rowIndex = 3;
        List<Integer> result = getRow(rowIndex);
        System.out.println(result);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> rows = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++) {
            rows.add(1);
            for(int j = i - 1; j > 0; j--) {
                rows.set(j, rows.get(j) + rows.get(j - 1));
            }
        }
        return rows;
    }
}
