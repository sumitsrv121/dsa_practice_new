package basic_recursion;

import basic_hashing.SumOfHighestAndLowestFrequency;

public class SumOfFirstNNumbers {
    public static void main(String[] args) {
        SumOfFirstNNumbers sum = new SumOfFirstNNumbers();
        System.out.println(sum.NnumbersSum(4));
    }

    public int NnumbersSum(int N) {
        if (N == 0) {
            return 0;
        }
        return N + NnumbersSum(N - 1);
    }
}
