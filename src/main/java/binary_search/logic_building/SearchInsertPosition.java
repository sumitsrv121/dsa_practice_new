package binary_search.logic_building;

public class SearchInsertPosition {
    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsertPosition.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsertPosition.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        int ans = nums.length;

        while (start <= end) {
            mid = start + ((end - start) / 2);

            if (nums[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
