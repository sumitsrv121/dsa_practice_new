package binary_search.twoDArray;

import java.util.Arrays;

public class FindPeakElementInMatrix {
    public static void main(String[] args) {
        FindPeakElementInMatrix findPeakElementInMatrix = new FindPeakElementInMatrix();
        System.out.println(Arrays.toString(findPeakElementInMatrix.findPeakGrid(new int[][]{{10, 20, 15}, {21, 30, 14}, {7, 16, 32}})));
        System.out.println(Arrays.toString(findPeakElementInMatrix.findPeakGrid(new int[][]{{10, 7}, {11, 17}})));
        System.out.println(Arrays.toString(findPeakElementInMatrix.findPeakGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }

    public int[] findPeakGrid(int[][] mat) {
        int m = mat[0].length;
        int low = 0;
        int high = m - 1;
        int mid;

        while (low <= high) {
            mid = low + ((high - low) / 2);

            int row = findRowWithMaxValueInGivenColumn(mat, mid);

            int left = mid - 1 >= 0 ? mat[row][mid - 1] : -1;
            int right = mid + 1 < m ? mat[row][mid + 1] : -1;

            if (left < mat[row][mid] && mat[row][mid] > right) {
                return new int[]{row, mid};
            } else if (left > mat[row][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    private int findRowWithMaxValueInGivenColumn(int[][] mat, int col) {
        int row = 0;
        int ans = -1;
        int max = Integer.MIN_VALUE;
        while (row < mat.length) {
            if (max < mat[row][col]) {
                max = mat[row][col];
                ans = row;
            }
            row++;
        }
        return ans;
    }
}
