package binary_search.fundamental;

public class LowerBound {
    public static void main(String[] args) {
        LowerBound lBound = new LowerBound();
        System.out.println(lBound.lowerBound(new int[]{1, 2, 2, 3}, 2));
        System.out.println(lBound.lowerBound(new int[]{3, 5, 8, 15, 19}, 9));
        System.out.println(lBound.lowerBound(new int[]{3, 5, 8, 15, 19}, 3));
    }

    public int lowerBound(int[] nums, int x) {
        int minIndex = -1;

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start <= end) {
            mid = start + ((end - start) / 2);

            if (nums[mid] >= x) {
                minIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return minIndex == -1 ? nums.length : minIndex;
    }
}
