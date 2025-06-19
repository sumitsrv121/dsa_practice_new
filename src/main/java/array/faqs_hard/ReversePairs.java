package array.faqs_hard;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs {
    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        System.out.println(reversePairs.reversePairs(new int[]{6, 4, 1, 2, 7}));
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int start, int end) {
        int count = 0;
        if (start < end) {
            int mid = (start + end) / 2;
            count += mergeSort(nums, start, mid);
            count += mergeSort(nums, mid + 1, end);
            count += countReversePairs(nums, start, mid, end);
            merge(nums, start, mid, end);
        }
        return count;
    }

    public int countReversePairs(int[] nums, int start, int mid, int end) {
        int l = start;
        int r = mid + 1;

        int count = 0;

        while (l <= mid) {
            while (r <= end && nums[l] > 2 * nums[r]) {
                r++;
            }
            count += (r - (mid + 1));
            l++;
        }
        return count;
    }

    public void merge(int[] nums, int start, int mid, int end) {
        List<Integer> auxAl = new ArrayList<>();

        int l = start;
        int r = mid + 1;

        while (l <= mid && r <= end) {
            if (nums[l] <= nums[r]) {
                auxAl.add(nums[l++]);
            } else {
                auxAl.add(nums[r++]);
            }
        }

        while (l <= mid) {
            auxAl.add(nums[l++]);
        }

        while (r <= end) {
            auxAl.add(nums[r++]);
        }

        for (int i = start, j = 0; i <= end; i++, j++) {
            nums[i] = auxAl.get(j);
        }
    }

    private static int bruteForceSolution(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > 2 * nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
