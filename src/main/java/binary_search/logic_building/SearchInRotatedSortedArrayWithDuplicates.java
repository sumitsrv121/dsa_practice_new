package binary_search.logic_building;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SearchInRotatedSortedArrayWithDuplicates {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(List.of(7, 8, 1, 2, 3, 3, 3, 4, 5, 6));
        SearchInRotatedSortedArrayWithDuplicates searchInRotatedSortedArrayWithDuplicates
                = new SearchInRotatedSortedArrayWithDuplicates();

        System.out.println(searchInRotatedSortedArrayWithDuplicates.searchInARotatedSortedArrayII(nums, 3));
        System.out.println(searchInRotatedSortedArrayWithDuplicates.searchInARotatedSortedArrayII(nums, 10));
        System.out.println(searchInRotatedSortedArrayWithDuplicates.searchInARotatedSortedArrayII(nums, 7));
    }

    public boolean searchInARotatedSortedArrayII(ArrayList<Integer> nums, int k) {
        int start = 0;
        int end = nums.size() - 1;
        int mid;

        while (start <= end) {
            mid = start + ((end - start) / 2);

            if (nums.get(mid) == k) {
                return true;
            } else if (Objects.equals(nums.get(mid), nums.get(start)) && Objects.equals(nums.get(mid), nums.get(end))) {
                // nums[mid] == nums[start] == nums[end] then move start and end
                start += 1;
                end -= 1;
            } else if (nums.get(start) <= nums.get(mid)) {
                // left sorted list
                if (nums.get(start) <= k && nums.get(mid) >= k) {
                    // if K lies in sorted half
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // right sorted list
                if (nums.get(mid) <= k && nums.get(end) >= k) {
                    // if K lies in sorted half
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
