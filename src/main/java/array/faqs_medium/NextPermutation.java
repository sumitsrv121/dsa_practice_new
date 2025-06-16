package array.faqs_medium;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{2, 1, 5, 4, 3, 0, 0};
        nextPermutation.nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int pivot = findPivot(nums);

        if (pivot == Integer.MIN_VALUE) {
            reverseArray(nums, 0, nums.length - 1);
            return;
        }

        for (int i = nums.length - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                break;
            }
        }

        reverseArray(nums, pivot + 1, nums.length - 1);
    }

    private void reverseArray(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    private int findPivot(int[] nums) {
        int pivotIndex = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                pivotIndex = i - 1;
                return pivotIndex;
            }
        }
        return pivotIndex;
    }
}
