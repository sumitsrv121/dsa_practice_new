package basic_array;

import java.util.Arrays;

public class SumOfArrayElements {
    public static void main(String[] args) {
        SumOfArrayElements sumOfArrayElements = new SumOfArrayElements();
        int[] x = {1, 2, 3};
        System.out.println(sumOfArrayElements.sum(x, x.length));

    }

    public int sum(int arr[], int n) {
        return Arrays.stream(arr)
                .sum();
    }
}
