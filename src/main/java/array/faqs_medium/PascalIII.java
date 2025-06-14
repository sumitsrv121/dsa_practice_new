package array.faqs_medium;

import java.util.ArrayList;
import java.util.List;

public class PascalIII {
    public static void main(String[] args) {
        PascalIII pascal = new PascalIII();

        System.out.println(pascal.pascalTriangleIII(6));
    }


    public List<List<Integer>> pascalTriangleIII(int n) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            pascalTriangle.add(nCr(i - 1, i - 1));
        }
        return pascalTriangle;
    }

    public List<Integer> nCr(int n, int r) {
        List<Integer> columns = new ArrayList<>();
        int ans = 1;
        columns.add(ans);
        for (int i = 1; i <= r; i++) {
            ans *= (n - i + 1);
            ans /= i;
            columns.add(ans);
        }

        return columns;
    }
}
