package array.faqs_medium;

import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 1, 0};

        Sort012 sort012 = new Sort012();
        sort012.sortZeroOneTwo(nums);

        System.out.println(Arrays.toString(nums));
    }

    public void sortZeroOneTwo(int[] nums) {
        int zeroIndex = 0;
        int oneIndex = 0;
        int twoIndex = nums.length - 1;

        while (oneIndex <= twoIndex)
            if (nums[oneIndex] == 1) {
                oneIndex++;
            } else if (nums[oneIndex] == 2) {
                swap(nums, oneIndex, twoIndex);
                twoIndex--;
            } else {
                swap(nums, zeroIndex, oneIndex);
                zeroIndex++;
                oneIndex++;
            }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
