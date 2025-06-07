package basic_math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivisorOfANumber {
    public static void main(String[] args) {
        DivisorOfANumber divisorOfANumber = new DivisorOfANumber();
        System.out.println(Arrays.toString(divisorOfANumber.divisors(8)));
    }

    public int[] divisors(int n) {
        List<Integer> al = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                al.add(i);
                if (n / i != i) {
                    al.add(n / i);
                }
            }
        }
        return al.stream().mapToInt(Integer::intValue)
                .sorted()
                .toArray();
    }
}
