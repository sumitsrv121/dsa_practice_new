package binary_search.logic_building;

import java.util.ArrayList;
import java.util.List;

public class NumberOfTimesSortedArrayIsRotated {
    public static void main(String[] args) {
        NumberOfTimesSortedArrayIsRotated numberOfTimesSortedArrayIsRotated
                = new NumberOfTimesSortedArrayIsRotated();

        System.out.println(numberOfTimesSortedArrayIsRotated.findKRotation(new ArrayList<>(List.of(4, 5, 6, 7, 0, 1, 2, 3))));
        System.out.println(numberOfTimesSortedArrayIsRotated.findKRotation(new ArrayList<>(List.of(3, 4, 5, 1, 2))));
        System.out.println(numberOfTimesSortedArrayIsRotated.findKRotation(new ArrayList<>(List.of(4, 5, 1, 2))));

    }

    public int findKRotation(ArrayList<Integer> nums) {
        int start = 0;
        int end = nums.size() - 1;
        int mid;
        int minVal = Integer.MAX_VALUE;
        int minValIndex = -1;

        while (start <= end) {
            mid = ((end + start) / 2);

            if (nums.get(start) <= nums.get(end)) {
                if (minVal > nums.get(start)) {
                    minVal = nums.get(start);
                    minValIndex = start;
                    break;
                }
            }

            if (nums.get(mid) >= nums.get(start)) {
                if (minVal > nums.get(start)) {
                    minVal = nums.get(start);
                    minValIndex = start;
                }
                start = mid + 1;
            } else {
                if (minVal > nums.get(mid)) {
                    minVal = nums.get(mid);
                    minValIndex = mid;
                }
                end = mid - 1;
            }
        }
        return minValIndex;
    }
}
