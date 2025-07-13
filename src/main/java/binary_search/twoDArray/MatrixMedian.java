package binary_search.twoDArray;

public class MatrixMedian {
    public static void main(String[] args) {
        MatrixMedian matrixMedian = new MatrixMedian();
        System.out.println(matrixMedian.findMedian(new int[][]{{1, 4, 15}, {2, 5, 6}, {3, 8, 11}}));
        System.out.println(matrixMedian.findMedian(new int[][]{{1, 3, 8}, {2, 3, 4}, {1, 2, 5}}));
        System.out.println(matrixMedian.findMedian(new int[][]{{1, 4, 9}, {2, 5, 6}, {3, 7, 8}}));
    }

    public int findMedian(int[][] matrix) {
        int target = (matrix.length * matrix[0].length) / 2;
        int low = findMin(matrix);
        int high = findMax(matrix, matrix[0].length - 1);
        int mid;
        int ans = -1;
        while (low <= high) {
            mid = low + ((high - low) / 2);

            int count = getCountOfElementsLessThanOrEqualToTarget(matrix, mid);

            if (count <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private int getCountOfElementsLessThanOrEqualToTarget(int[][] matrix, int target) {
        int count = 0;
        for (int[] arr : matrix) {
            count += findCeil(arr, target);
        }
        return count;
    }

    private int findCeil(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        int ans = arr.length;

        while (low <= high) {
            mid = low + ((high - low) / 2);

            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private int findMax(int[][] matrix, int col) {
        int max = Integer.MIN_VALUE;

        for (int[] ints : matrix) {
            if (max < ints[col]) {
                max = ints[col];
            }
        }
        return max;
    }

    private int findMin(int[][] matrix) {
        int min = Integer.MAX_VALUE;

        for (int[] ints : matrix) {
            if (min > ints[0]) {
                min = ints[0];
            }
        }
        return min;
    }
}
