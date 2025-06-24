package binary_search.fundamental;

public class SearchXInSortedArray {
    public static void main(String[] args) {
        SearchXInSortedArray searchXInSortedArray = new SearchXInSortedArray();
        System.out.println(searchXInSortedArray.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(searchXInSortedArray.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));

    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = ((end - start) / 2) + start;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
