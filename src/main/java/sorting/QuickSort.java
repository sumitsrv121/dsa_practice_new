package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        System.out.println(Arrays.toString(qs.quickSort(new int[]{7, 6, 1, 5, 2, 4, 9})));

    }

    public int[] quickSort(int[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSortHelper(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = findPartition(nums, start, end);
        quickSortHelper(nums, start, pivot - 1);
        quickSortHelper(nums, pivot + 1, end);
    }

    private int findPartition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start;
        int j = end;

        while (i < j) {
            while (i <= end && nums[i] <= pivot) {
                i++;
            }

            while (j > start && nums[j] > pivot) {
                j--;
            }

            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, start, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
