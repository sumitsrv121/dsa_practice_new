package array.logic_building;

import java.util.Arrays;

public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 4, 0, 5, 2};
        int[] nums1 = new int[]{0, 0, 0, 1, 3, -2};
        int[] nums2 = new int[]{1, 2, 3, 4, 0, 5};
        int[] nums3 = new int[]{0, 20, 0, -20, 0, 20};
        MoveZeroesToEnd moveZeroesToEnd = new MoveZeroesToEnd();
        moveZeroesToEnd.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        moveZeroesToEnd.moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));
        moveZeroesToEnd.moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2));
        moveZeroesToEnd.moveZeroes(nums3);
        System.out.println(Arrays.toString(nums3));
    }

    public void moveZeroes(int[] nums) {
        int zerothIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zerothIndex++] = nums[i];
            }
        }

        for (int i = zerothIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
