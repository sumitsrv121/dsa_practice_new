package binary_search.logic_building;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();

        System.out.println(searchInRotatedSortedArray.search(nums, 0));
        System.out.println(searchInRotatedSortedArray.search(nums, 3));
        System.out.println(searchInRotatedSortedArray.search(nums, 5));
    }

    public int search(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = ((end - start) / 2) + start;

            if (nums[mid] == k) {
                return mid;
            }

            // left half sorted
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= k && nums[mid] > k) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // right half sorted
                if (nums[mid] < k && nums[end] >= k) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }
}