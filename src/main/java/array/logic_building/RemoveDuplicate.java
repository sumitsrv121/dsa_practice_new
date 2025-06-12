package array.logic_building;

import java.util.Arrays;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] nums = {0, 0, 3, 3, 5, 6};
        int[] nums1 = {-2, 2, 4, 4, 4, 4, 5, 5};
        int[] nums2 = {-30, -30, 0, 0, 10, 20, 30, 30};
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        System.out.println(removeDuplicate.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
        System.out.println(removeDuplicate.removeDuplicates(nums1));
        System.out.println(Arrays.toString(nums1));
        System.out.println(removeDuplicate.removeDuplicates(nums2));
        System.out.println(Arrays.toString(nums2));
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;

        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
}
