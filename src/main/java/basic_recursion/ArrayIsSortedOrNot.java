package basic_recursion;

import java.util.ArrayList;
import java.util.List;

public class ArrayIsSortedOrNot {
    public static void main(String[] args) {
        ArrayIsSortedOrNot arrayIsSortedOrNot = new ArrayIsSortedOrNot();
        System.out.println(arrayIsSortedOrNot.isSorted(new ArrayList<>(List.of(1, 2, 3, 4, 5))));
        System.out.println(arrayIsSortedOrNot.isSorted(new ArrayList<>(List.of(1, 2, 3, 4, 5, 1))));
    }

    public boolean isSorted(ArrayList<Integer> nums) {
        return isListSorted(nums, 1);
    }

    private boolean isListSorted(ArrayList<Integer> nums, int i) {
        if (i == nums.size()) {
            return true;
        }

        return nums.get(i - 1) <= nums.get(i) && isListSorted(nums, i + 1);
    }
}
