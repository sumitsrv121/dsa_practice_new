package binary_search.logic_building;

import java.util.ArrayList;
import java.util.List;

public class FindMinimumInSortedRotatedArray {
    public static void main(String[] args) {
        FindMinimumInSortedRotatedArray findMinimumInSortedRotatedArray = new FindMinimumInSortedRotatedArray();
        System.out.println(findMinimumInSortedRotatedArray.findMin(new ArrayList<>(List.of(4, 5, 6, 7, 0, 1, 2, 3))));
        System.out.println(findMinimumInSortedRotatedArray.findMin(new ArrayList<>(List.of(3, 4, 5, 1, 2))));
        System.out.println(findMinimumInSortedRotatedArray.findMin(new ArrayList<>(List.of(4, 5, 6, 7, -7, 1, 2, 3))));
    }

    public int findMin(ArrayList<Integer> arr) {
        int start = 0;
        int end = arr.size() - 1;
        int mid;
        int ans = Integer.MAX_VALUE;

        while (start <= end) {
            mid = start + ((end - start) / 2);

            if (arr.get(start) <= arr.get(end)) {
                ans = Math.min(ans, arr.get(start));
                break;
            }

            if (arr.get(start) <= arr.get(mid)) {
                ans = Math.min(ans, arr.get(start));
                start = mid + 1;
            } else {
                ans = Math.min(ans, arr.get(mid));
                end = mid - 1;
            }
        }
        return ans;
    }
}
