package array.contest;

import java.util.HashSet;
import java.util.Set;

public class MaximumConsecutiveGoodNumber {
    public static void main(String[] args) {
        MaximumConsecutiveGoodNumber maximumConsecutiveGoodNumber = new MaximumConsecutiveGoodNumber();

        System.out.println(maximumConsecutiveGoodNumber.maxConsecutiveGoodNums(new int[]{1, 2, 3, 5, 4, 5, 1}, new int[]{3, 5}));
        System.out.println(maximumConsecutiveGoodNumber.maxConsecutiveGoodNums(new int[]{4, 8, 1, 2, 0, 4, 6}, new int[]{1, 4, 2, 6}));

    }


    public int maxConsecutiveGoodNums(int[] nums, int[] goodNumbers) {
        Set<Integer> bucketSet = new HashSet<>();

        for (int goodNumber : goodNumbers) {
            bucketSet.add(goodNumber);
        }

        int count = 0;
        int maxCount = Integer.MIN_VALUE;

        for (int num : nums) {
            if (bucketSet.contains(num)) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        return maxCount == Integer.MIN_VALUE ? count : maxCount;
    }
}
