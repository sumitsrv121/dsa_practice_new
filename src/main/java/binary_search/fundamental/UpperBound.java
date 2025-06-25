package binary_search.fundamental;

public class UpperBound {
    public static void main(String[] args) {
        UpperBound uBound = new UpperBound();
        System.out.println(uBound.upperBound(new int[]{3, 5, 8, 15, 19}, 3));
        System.out.println(uBound.upperBound(new int[]{3, 5, 8, 15, 19}, 9));
        System.out.println(uBound.upperBound(new int[]{1, 2, 2, 3}, 2));
    }

    public int upperBound(int[] nums, int x) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        int result = -1;

        while (start <= end) {
            mid = start + ((end - start) / 2);

            if (nums[mid] <= x) {
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }
        return result == -1 ? nums.length : result;
    }
}
