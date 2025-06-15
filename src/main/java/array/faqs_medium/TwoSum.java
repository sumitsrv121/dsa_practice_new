package array.faqs_medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum tSum = new TwoSum();
        System.out.println(Arrays.toString(tSum.twoSum(new int[]{1, 6, 2, 10, 3}, 7)));
        System.out.println(tSum.optimalSolution(new int[]{1, 6, 2, 10, 3}, 7));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> bucket = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int desiredNumber = target - nums[i];

            if (bucket.containsKey(desiredNumber)) {
                return new int[]{bucket.get(desiredNumber), i};
            }
            bucket.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    private static int[] bruteForceSolution(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private boolean optimalSolution(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] + nums[end] == target) {
                return true;
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }
}
