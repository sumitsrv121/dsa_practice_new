package array.faqs_medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        SpiralMatrix sm = new SpiralMatrix();
        System.out.println(sm.spiralOrder(arr));
        System.out.println(sm.spiralOrder(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
        System.out.println(sm.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}}));
        System.out.println(sm.spiralOrder(new int[][]{{1, 2, 3, 4, 5, 6}, {20, 21, 22, 23, 24, 7}, {19, 32, 33, 34, 25, 8}, {18, 31, 36, 35, 26, 9}, {17, 30, 29, 28, 27, 10}, {16, 15, 14, 13, 12, 11}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> al = new ArrayList<>();

        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;

        while (top <= bottom && left <= right) {

            // left to right
            for (int j = left; j <= right; j++) {
                al.add(matrix[top][j]);
            }
            top++;

            // top to down
            for (int i = top; i <= bottom; i++) {
                al.add(matrix[i][right]);
            }
            right--;

            // right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    al.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // bottom to up
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    al.add(matrix[i][left]);
                }
                left++;
            }
        }
        return al;
    }
}
