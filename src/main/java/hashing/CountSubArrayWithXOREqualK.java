package hashing;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrayWithXOREqualK {
    public static void main(String[] args) {
        CountSubArrayWithXOREqualK countSubArrayWithXOREqualK = new CountSubArrayWithXOREqualK();

        System.out.println(countSubArrayWithXOREqualK.subarraysWithXorK(new int[]{4, 2, 2, 6, 4}, 6));
        System.out.println(countSubArrayWithXOREqualK.subarraysWithXorK(new int[]{5, 6, 7, 8, 9}, 5));
        System.out.println(countSubArrayWithXOREqualK.subarraysWithXorK(new int[]{5, 2, 9}, 7));
    }

    public int subarraysWithXorK(int[] nums, int k) {
        Map<Integer, Integer> prefixXORResultToCount = new HashMap<>();
        prefixXORResultToCount.put(0, 1);

        int result = 0;
        int count = 0;

        for (int num: nums) {
            result ^= num;

            if (prefixXORResultToCount.containsKey(result ^ k)) {
                count += prefixXORResultToCount.get(result ^ k);
            }
            prefixXORResultToCount.merge(result, 1, Integer::sum);
        }
        return count;
    }

    private static int bruteForceSolution(int[] nums, int k) {
        int count = 0;
        int result;
        for (int i = 0; i < nums.length; i++) {
            result = 0;
            for (int j = i; j < nums.length; j++) {
                result ^= nums[j];
                if (result == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
