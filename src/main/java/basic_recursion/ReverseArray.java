package basic_recursion;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        ReverseArray reverseArray = new ReverseArray();
        System.out.println(Arrays.toString(reverseArray.reverseArray(new int[]{1, 2, 3, 4, 5})));
    }

    public int[] reverseArray(int[] nums) {
        return reverseArray(nums, 0, nums.length - 1);
    }

    private int[] reverseArray(int[] nums, int start, int end) {
        if (start >= end) {
            return nums;
        }

        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;

        return reverseArray(nums, start + 1, end - 1);
    }
}
