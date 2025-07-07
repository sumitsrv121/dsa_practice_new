package binary_search.twoDArray;

public class Maximum1s {
    public static void main(String[] args) {
        Maximum1s maximum1s = new Maximum1s();
        System.out.println(maximum1s.rowWithMax1s(new int[][]{{1, 1, 1}, {0, 0, 1}, {0, 0, 0}}));
        System.out.println(maximum1s.rowWithMax1s(new int[][]{{0, 0}, {0, 0}}));
        System.out.println(maximum1s.rowWithMax1s(new int[][]{{0, 0, 1}, {0, 1, 1}, {0, 1, 1}}));
    }

    public int rowWithMax1s(int[][] mat) {
        int maxOnesCountRow = -1;
        int maxOnesCount = 0;
        for (int i = 0; i < mat.length; i++) {
            // for each row find the number of ones
            int onesCount = findNumberOf1s(mat[i]);

            if (onesCount > maxOnesCount) {
                maxOnesCountRow = i;
                maxOnesCount = onesCount;
            }
        }
        return maxOnesCountRow;
    }

    private int findNumberOf1s(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        int ans = -1;
        while (low <= high) {
            mid = low + ((high - low) / 2);

            if (nums[mid] == 1) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans == -1 ? 0 : nums.length - ans;
    }
}
