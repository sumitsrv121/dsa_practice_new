package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {7, 4, 1, 5, 3};

        MergeSort ms = new MergeSort();
        System.out.println(Arrays.toString(ms.mergeSort(nums)));
        System.out.println(Arrays.toString(ms.mergeSort(new int[]{5, 4, 4, 1, 1})));
    }

    public int[] mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] aux = new int[end - start + 1];
        int left = start;
        int right = mid + 1;
        int i = 0;

        while (left <= mid && right <= end) {
            if (nums[left] <= nums[right]) {
                aux[i++] = nums[left++];
            } else {
                aux[i++] = nums[right++];
            }
        }

        while (left <= mid) {
            aux[i++] = nums[left++];
        }

        while (right <= end) {
            aux[i++] = nums[right++];
        }

        i = 0;
        for (int j = start; j <= end; j++) {
            nums[j] = aux[i++];
        }
    }
}
