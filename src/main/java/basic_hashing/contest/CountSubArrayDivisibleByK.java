package basic_hashing.contest;

import hashing.CountSubArrayWithXOREqualK;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrayDivisibleByK {
    public static void main(String[] args) {
        CountSubArrayDivisibleByK countSubArrayWithXOREqualK = new CountSubArrayDivisibleByK();

        System.out.println(countSubArrayWithXOREqualK.subarraySumDivisbleByK(new int[]{3, 1, 4, 1}, 3));
        System.out.println(countSubArrayWithXOREqualK.subarraySumDivisbleByK(new int[]{5, 10, -5, 20}, 7));
    }

    public int subarraySumDivisbleByK(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        int mod;

        Map<Integer, Integer> modToCount = new HashMap<>();
        modToCount.put(0, 1);

        for (int num : nums) {
            sum += num;

            mod = ((sum % k) + k) % k;

            if (modToCount.containsKey(mod)) {
                count += modToCount.get(mod);
            }
            modToCount.merge(mod, 1, Integer::sum);
        }

        return count;
    }
}
