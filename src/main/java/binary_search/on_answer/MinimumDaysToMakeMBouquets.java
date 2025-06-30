package binary_search.on_answer;

public class MinimumDaysToMakeMBouquets {
    public static void main(String[] args) {
        MinimumDaysToMakeMBouquets minimumDaysToMakeMBouquets = new MinimumDaysToMakeMBouquets();
        System.out.println(minimumDaysToMakeMBouquets.roseGarden(8, new int[]{7, 7, 7, 7, 13, 11, 12, 7}, 3, 2));
        System.out.println(minimumDaysToMakeMBouquets.roseGarden(5, new int[]{1, 10, 3, 10, 2}, 2, 3));
        System.out.println(minimumDaysToMakeMBouquets.roseGarden(5, new int[]{1, 10, 3, 10, 2}, 1, 3));
    }

    public int roseGarden(int n, int[] nums, int k, int m) {
        if (k * m > n) {
            return -1;
        }

        int startDay = Integer.MAX_VALUE;
        int endDay = Integer.MIN_VALUE;

        for (int num : nums) {
            if (startDay > num) {
                startDay = num;
            }

            if (endDay < num) {
                endDay = num;
            }
        }

        int midDay;
        int ans = -1;

        while (startDay <= endDay) {
            midDay = startDay + ((endDay - startDay) / 2);
            long numberOfBouquets = getNumberOfBouquets(nums, midDay, k);

            if (numberOfBouquets >= m) {
                ans = midDay;
                endDay = midDay - 1;
            } else {
                startDay = midDay + 1;
            }
        }
        return ans;
    }

    public long getNumberOfBouquets(int[] nums, int day, int k) {
        long numberOfBouquets = 0;
        int count = 0;

        for (int num : nums) {
            if (num <= day) {
                count++;
            } else {
                count = 0;
            }
            if (count == k) {
                numberOfBouquets++;
                count = 0;
            }
        }

        return numberOfBouquets;
    }

}
