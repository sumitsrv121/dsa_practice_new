package binary_search.twoDArray;

public class SearchInSortedMatrix {
    public static void main(String[] args) {
        SearchInSortedMatrix searchInSortedMatrix = new SearchInSortedMatrix();
        System.out.println(searchInSortedMatrix.searchMatrix(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}, 8));
        System.out.println(searchInSortedMatrix.searchMatrix(new int[][]{{1, 2, 4}, {6, 7, 8}, {9, 10, 34}}, 78));
        System.out.println(searchInSortedMatrix.searchMatrix(new int[][]{{1, 2, 4}, {6, 7, 8}, {9, 10, 34}}, 7));
    }

    public boolean searchMatrix(int[][] mat, int target) {
        int noOfRows = mat.length;
        int noOfColumns = mat[0].length;

        int n = noOfColumns * noOfRows;

        int low = 0;
        int high = n - 1;
        int mid;

        while (low <= high) {
            mid = low + ((high - low) / 2);

            int row = mid / noOfColumns;
            int column = mid % noOfColumns;

            if (mat[row][column] == target) {
                return true;
            } else if (mat[row][column] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
