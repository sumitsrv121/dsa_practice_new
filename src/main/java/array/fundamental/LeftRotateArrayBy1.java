package array.fundamental;

import java.util.Arrays;

public class LeftRotateArrayBy1 {
    public static void main(String[] args) {
        LeftRotateArrayBy1 lra = new LeftRotateArrayBy1();

        int[] nums = {1, 2, 3, 4, 5};
        lra.rotateArrayByOne(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void rotateArrayByOne(int[] nums) {
        reverse(nums, 1, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
