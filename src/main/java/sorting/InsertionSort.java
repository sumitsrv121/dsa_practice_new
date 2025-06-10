package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        System.out.println(Arrays.toString(is.insertionSort(new int[]{7, 4, 1, 5, 3})));
    }

    public int[] insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int hole = i;
            int val = nums[hole];
            while(hole > 0 && val < nums[hole -1]) {
                nums[hole] = nums[hole-1];
                hole--;
            }
            nums[hole] = val;
        }
        return nums;
    }
}
