package binary_search.logic_building;

import java.util.Arrays;

public class FirstAndLastOccurrence {
    public static void main(String[] args) {
        FirstAndLastOccurrence firstAndLastOccurrence = new FirstAndLastOccurrence();
        System.out.println(Arrays.toString(firstAndLastOccurrence.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(firstAndLastOccurrence.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(firstAndLastOccurrence.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 5)));

    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirstOccurrence(nums, target), findLastOccurrence(nums, target)};
    }

    public int findFirstOccurrence(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        int firstIndex = -1;

        while (start <= end) {
            mid = start + ((end - start) / 2);

            if (nums[mid] == target) {
                firstIndex = mid;
                end = mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return firstIndex;
    }

    public int findLastOccurrence(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        int lastIndex = -1;

        while (start <= end) {
            mid = start + ((end - start) / 2);

            if (nums[mid] == target) {
                lastIndex = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return lastIndex;
    }
}
