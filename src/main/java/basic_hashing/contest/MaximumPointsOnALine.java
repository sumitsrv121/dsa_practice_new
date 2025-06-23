package basic_hashing.contest;

import java.util.HashMap;
import java.util.Map;

public class MaximumPointsOnALine {
    public static void main(String[] args) {
        MaximumPointsOnALine maximumPointsOnALine = new MaximumPointsOnALine();
        //System.out.println(maximumPointsOnALine.maximumPointsOnALine(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}}));
        //System.out.println(maximumPointsOnALine.maximumPointsOnALine(new int[][]{{0, 1}, {2, 3}, {4, 5}, {1, 2}, {3, 4}, {2, 2}}));
        System.out.println(maximumPointsOnALine.maximumPointsOnALine(new int[][]{{2, 3}, {3, 3}, {-5, 3}}));

    }

    public int maximumPointsOnALine(int[][] nums) {
        int maxCount = 1;

        for (int i = 0; i < nums.length; i++) {
            Map<Double, Integer> slopeToCount = new HashMap<>();

            int[] p1 = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                int[] p2 = nums[j];

                double slope;
                if (p2[0] == p1[0]) {
                    slope = Double.POSITIVE_INFINITY;
                } else {
                    slope = ((double) (p2[1] - p1[1]) / (double) (p2[0] - p1[0]));

                    if (slope == -0.0) {
                        slope = 0.0;
                    }
                }
                slopeToCount.merge(slope, 1, Integer::sum);

                maxCount = Math.max(maxCount, slopeToCount.get(slope) + 1);
            }
        }
        return maxCount;
    }
}
