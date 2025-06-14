package array.faqs_medium;

import java.util.Arrays;

public class PascalII {
    public static void main(String[] args) {
        PascalII pascalII = new PascalII();
        System.out.println(Arrays.toString(pascalII.pascalTriangleII(6)));
        System.out.println(Arrays.toString(pascalII.pascalTriangleII(5)));
    }

    public int[] pascalTriangleII(int r) {
        return nCr(r - 1, r - 1);
    }

    public int[] nCr(int n, int r) {
        int[] al = new int[n + 1];
        int ans = 1;
        int k = 0;
        al[k++] = ans;
        for (int i = 1; i <= r; i++) {
            ans *= (n - i + 1);
            ans /= i;
            al[k++] = ans;
        }
        return al;
    }
}
