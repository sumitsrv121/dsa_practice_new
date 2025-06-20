package array.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfJumps {
    public static void main(String[] args) {
        NumberOfJumps numberOfJumps = new NumberOfJumps();

        System.out.println(numberOfJumps.NumberOfJumps(new int[]{3, 1, 10, 6, 5}, 2));
        System.out.println(numberOfJumps.NumberOfJumps(new int[]{1, 4, 5, 1, 7}, 3));

    }

    public int NumberOfJumps(int[] nums, int k) {
        return mergeSort(nums, 0, nums.length -1, k);
    }

    public int mergeSort(int[] nums, int start, int end, int k) {
        int count = 0;
        if(start < end) {
            int mid = (start + end) / 2;
            count += mergeSort(nums, start, mid, k);
            count += mergeSort(nums, mid + 1, end, k);
            count += countJumps(nums, start, mid, end, k);
            merge(nums, start, mid, end);
        }

        return count;
    }

    private int countJumps(int[] nums, int start, int mid, int end, int k) {
        int count = 0;
        for (int i = start; i <= mid; i++) {
            int j = mid + 1;
            while (j <= end && nums[i] + k >= nums[j]) {
                j++;
            }
            count += (end - j + 1);
        }
        return count;
    }


    public void merge(int[] nums, int start, int mid, int end) {
        List<Integer> al = new ArrayList<>();
        int l = start;
        int r = mid +1;

        while(l <= mid && r <= end) {
            if(nums[l] < nums[r]) {
                al.add(nums[l++]);
            } else {
                al.add(nums[r++]);
            }
        }

        while(l <= mid) {
            al.add(nums[l++]);
        }

        while(r <= end) {
            al.add(nums[r++]);
        }

        for (int i = start, j=0; i <= end; i++, j++) {
            nums[i] = al.get(j);
        }
    }

    private static int bruteForce(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + k < nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
