package array.faqs_hard;

import java.util.ArrayList;
import java.util.List;

public class CountInversions {

    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 1, 3, 5};

        CountInversions countInversions = new CountInversions();
        System.out.println(countInversions.numberOfInversions(nums));
    }

    public long numberOfInversions(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public long mergeSort(int[] arr, int start, int end) {
        long count = 0;
        if (start < end) {
            int mid = (start + end) / 2;
            count += mergeSort(arr, start, mid);
            count += mergeSort(arr, mid + 1, end);
            count += merge(arr, start, mid, end);
        }
        return count;
    }

    private long merge(int[] arr, int start, int mid, int end) {
        int l = start;
        int r = mid + 1;
        long count = 0;

        List<Integer> al = new ArrayList<>();


        while (l <= mid && r <= end) {
            if (arr[r] >= arr[l]) {
                al.add(arr[l++]);
            } else {
                count += (mid - l + 1);
                al.add(arr[r++]);
            }
        }

        while (l <= mid) {
            al.add(arr[l++]);
        }

        while (r <= end) {
            al.add(arr[r++]);
        }

        for (int i = start, j = 0; i <= end; i++, j++) {
            arr[i] = al.get(j);
        }
        return count;
    }

    private static long bruteForceSolution(int[] nums) {
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
