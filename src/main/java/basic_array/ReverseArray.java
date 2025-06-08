package basic_array;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        ReverseArray reverseArray = new ReverseArray();
        System.out.println(Arrays.toString(reverseArray.reverseArray(arr)));
    }

    public int[] reverseArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
        return nums;
    }
}
