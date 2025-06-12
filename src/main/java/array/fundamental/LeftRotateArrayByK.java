package array.fundamental;

import java.util.Arrays;

public class LeftRotateArrayByK {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int[] nums1 = {3, 4, 1, 5, 3, -5};
        LeftRotateArrayByK leftRotateArrayByK = new LeftRotateArrayByK();
        leftRotateArrayByK.rotateArray(nums, 2);
        System.out.println(Arrays.toString(nums));
        leftRotateArrayByK.rotateArray(nums1, 8);
        System.out.println(Arrays.toString(nums1));
    }

    public void rotateArray(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
