package binary_search.faq;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        AggressiveCows aggressiveCows = new AggressiveCows();
        System.out.println(aggressiveCows.aggressiveCows(new int[]{0, 3, 4, 7, 10, 9}, 4));
        System.out.println(aggressiveCows.aggressiveCows(new int[]{4, 2, 1, 3, 6}, 2));
        System.out.println(aggressiveCows.aggressiveCows(new int[]{10, 1, 2, 7, 5}, 3));
    }

    public int aggressiveCows(int[] nums, int k) {
        // sort array
        Arrays.sort(nums);

        int minDistance = 1;
        MinMax minAndMax = findMinAndMax(nums);
        int maxDistance = minAndMax.max - minAndMax.min;
        int midDistance;
        int ans = -1;

        while (minDistance <= maxDistance) {
            midDistance = minDistance + ((maxDistance - minDistance) / 2);
            int noOfCows = getNumberOfCowsWhichCanPlacedInStallAtMinDistanceD(nums, midDistance);

            if (noOfCows >= k) {
                ans = midDistance;
                minDistance = midDistance + 1;
            } else {
                maxDistance = midDistance - 1;
            }
        }
        return ans;
    }

    private MinMax findMinAndMax(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (min > num) {
                min = num;
            }

            if (max < num) {
                max = num;
            }
        }
        return new MinMax(min, max);
    }

    public int getNumberOfCowsWhichCanPlacedInStallAtMinDistanceD(int[] nums, int d) {
        int count = 1;
        int lastPosition = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - lastPosition >= d) {
                count++;
                lastPosition = nums[i];
            }
        }
        return count;
    }

    record MinMax(int min, int max) {
    }
}
