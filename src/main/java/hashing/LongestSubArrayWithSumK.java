package hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        LongestSubArrayWithSumK longestSubArrayWithSumK = new LongestSubArrayWithSumK();

        //System.out.println(longestSubArrayWithSumK.longestSubarray(new int[]{10, 5, 2, 7, 1, 9}, 15));
        //System.out.println(longestSubArrayWithSumK.longestSubarray(new int[]{-3, 2, 1}, 6));
        //System.out.println(longestSubArrayWithSumK.longestSubarray(new int[]{-1, 1, 1}, 1));
        System.out.println(longestSubArrayWithSumK.longestSubarray(new int[]{1, 2, 3, -2, 2, 4, -1, 1, 2, -1}, 5));

    }

    public int longestSubarray(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }

        }

        return maxLen;
    }

    private static int bruteForceSolution(int[] nums, int k) {
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    maxLength = Math.max(maxLength, (j - i + 1));
                }
            }
        }

        return maxLength;
    }

    private static int longestSubArrayWithAllPositiveSumK(int[] nums, int k) {
        int i = 0;
        int j = 0;

        int maxLen = 0;
        int sum = 0;

        while (i < nums.length && j < nums.length) {
            sum += nums[j];

            if (sum == k) {
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            } else if (sum < k) {
                j++;
                sum -= nums[i];
                i++;
            } else {
                sum -= (nums[i] + nums[j]);
                i++;
            }
        }

        return maxLen;

    }
}
