package binary_search.on_answer;

import java.util.Arrays;

public class KoKoEatingBanana {
    public static void main(String[] args) {
        KoKoEatingBanana koKoEatingBanana = new KoKoEatingBanana();
        //System.out.println(koKoEatingBanana.minimumRateToEatBananas(new int[]{7, 15, 6, 3}, 8));
        //System.out.println(koKoEatingBanana.minimumRateToEatBananas(new int[]{25, 12, 8, 14, 19}, 5));
        //System.out.println(koKoEatingBanana.minimumRateToEatBananas(new int[]{3, 7, 6, 11}, 8));
        //System.out.println(koKoEatingBanana.minimumRateToEatBananas(new int[]{238, 838, 453, 264}, 816));
        System.out.println(koKoEatingBanana.minimumRateToEatBananas(new int[]{805306368, 805306368, 805306368}, 1000000000));
    }

    public int minimumRateToEatBananas(int[] nums, int h) {
        if (nums.length == 0) {
            return 0;
        }
        int maxRate = Arrays.stream(nums).max().getAsInt();

        return findCapacity(nums, h, 1, maxRate);
    }

    private int findCapacity(int[] nums, int h, int start, int end) {
        int mid;
        int ans = -1;

        while (start <= end) {
            mid = start + ((end - start) / 2);
            long eatingRate = findRateOfEating(nums, mid);

            if (eatingRate <= h) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private long findRateOfEating(int[] nums, int rate) {
        long sum = 0;
        for (int num : nums) {
            sum += ((num % rate != 0 ? 1 : 0) + (num / rate));
        }
        return sum;
    }
}
