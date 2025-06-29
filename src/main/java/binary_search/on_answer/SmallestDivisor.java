package binary_search.on_answer;

import java.util.Arrays;

public class SmallestDivisor {
    public static void main(String[] args) {
        SmallestDivisor divisor = new SmallestDivisor();
        System.out.println(divisor.smallestDivisor(new int[]{1, 2, 3, 4, 5}, 8));
        System.out.println(divisor.smallestDivisor(new int[]{8, 4, 2, 3}, 10));
        System.out.println(divisor.smallestDivisor(new int[]{8, 4, 2, 3}, 4));
    }

    public int smallestDivisor(int[] nums, int limit) {
        if (nums.length == 0) {
            return -1;
        }
        int start = 1;
        int end = Arrays.stream(nums).max().getAsInt();
        int ans = -1;
        int mid;

        while (start <= end) {
            mid = start + ((end - start) / 2);

            long sum = compareDivisorSumWithLimit(nums, mid);

            if (sum <= limit) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private long compareDivisorSumWithLimit(int[] nums, int mid) {
        long sum = 0;
        for (int num : nums) {
            sum += ((num % mid != 0 ? 1 : 0) + num / mid);
        }
        return sum;
    }
}
