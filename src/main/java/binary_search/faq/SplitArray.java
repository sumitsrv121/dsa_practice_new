package binary_search.faq;

public class SplitArray {
    public static void main(String[] args) {
        SplitArray splitArray = new SplitArray();
        System.out.println(splitArray.largestSubarraySumMinimized(new int[]{1, 2, 3, 4, 5}, 3));
        System.out.println(splitArray.largestSubarraySumMinimized(new int[]{3, 5, 1}, 3));
        System.out.println(splitArray.largestSubarraySumMinimized(new int[]{1, 2, 3, 4, 5}, 2));
    }

    public int largestSubarraySumMinimized(int[] a, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int num : a) {
            if (low < num) {
                low = num;
            }
            high += num;
        }
        int mid;
        int ans = -1;

        while (low <= high) {
            mid = low + ((high - low) / 2);
            int count = numberOfSumArray(a, mid);

            if (count <= k) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private int numberOfSumArray(int[] arr, int maxSum) {
        int sum = 0;
        int count = 1;

        for (int num : arr) {
            int currentSum = sum + num;
            if (currentSum <= maxSum) {
                sum = currentSum;
            } else {
                sum = num;
                count++;
            }
        }
        return count;
    }
}
