package binary_search.logic_building;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        SingleElementInSortedArray singleElementInSortedArray = new SingleElementInSortedArray();

        System.out.println(singleElementInSortedArray.singleNonDuplicate(new int[]{1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6}));
        System.out.println(singleElementInSortedArray.singleNonDuplicate(new int[]{1, 1, 3, 5, 5}));
        System.out.println(singleElementInSortedArray.singleNonDuplicate(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7}));

    }

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (nums[0] != nums[1]) {
            return nums[0];
        } else if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start <= end) {
            mid = start + ((end - start) / 2);

            if (nums[mid] != nums[mid - 1] && nums[mid + 1] != nums[mid]) {
                return nums[mid];
            }

            if (mid % 2 != 0) {
                if (nums[mid - 1] == nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[mid] == nums[mid + 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
