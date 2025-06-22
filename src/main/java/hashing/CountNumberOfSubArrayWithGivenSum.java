package hashing;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfSubArrayWithGivenSum {
    public static void main(String[] args) {
        CountNumberOfSubArrayWithGivenSum countNumberOfSubArrayWithGivenSum =
                new CountNumberOfSubArrayWithGivenSum();

        System.out.println(countNumberOfSubArrayWithGivenSum.subarraySum(new int[]{1, 1, 1}, 2));
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumToCount = new HashMap<>();
        prefixSumToCount.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num: nums) {
            sum += num;

            if (prefixSumToCount.containsKey(sum - k)) {
                count += prefixSumToCount.get(sum - k);
            }
            prefixSumToCount.merge(sum, 1, Integer::sum);
        }

        return count;
    }

    private static int bruteForce(int[] nums, int k) {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
