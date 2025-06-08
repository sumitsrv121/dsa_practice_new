package basic_array;

import java.util.Arrays;

public class CountOddNumbersInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        CountOddNumbersInArray countOddNumbersInArray = new CountOddNumbersInArray();
        System.out.println(countOddNumbersInArray.countOdd(arr, arr.length));
    }

    public int countOdd(int[] arr, int n) {
        return (int) Arrays.stream(arr)
                .filter(x -> x % 2 != 0)
                .count();
    }
}
