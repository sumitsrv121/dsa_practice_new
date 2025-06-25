package binary_search.logic_building;

import java.util.Arrays;

public class FloorAndCeil {
    public static void main(String[] args) {
        FloorAndCeil floorAndCeil = new FloorAndCeil();

        System.out.println(Arrays.toString(floorAndCeil.getFloorAndCeil(new int[]{3, 4, 4, 7, 8, 10}, 5)));
        System.out.println(Arrays.toString(floorAndCeil.getFloorAndCeil(new int[]{3, 4, 4, 7, 8, 10}, 8)));
        System.out.println(Arrays.toString(floorAndCeil.getFloorAndCeil(new int[]{2, 4, 6, 8, 10, 12, 14}, 1)));

    }

    public int[] getFloorAndCeil(int[] nums, int x) {
        return new int[]{getFloorValue(nums, x), getCeilValue(nums, x)};
    }

    public int getFloorValue(int[] nums, int x) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        int floorValue = -1;

        while (start <= end) {
            mid = start + ((end - start) / 2);

            if (nums[mid] <= x) {
                floorValue = nums[mid];
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return floorValue;
    }

    public int getCeilValue(int[] nums, int x) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        int ceilValue = -1;

        while (start <= end) {
            mid = start + ((end - start) / 2);

            if (nums[mid] >= x) {
                ceilValue = nums[mid];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ceilValue;
    }
}
