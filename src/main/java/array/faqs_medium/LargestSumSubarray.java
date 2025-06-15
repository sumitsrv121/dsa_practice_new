package array.faqs_medium;

public class LargestSumSubarray {
    public static void main(String[] args) {
        LargestSumSubarray largestSumSubarray = new LargestSumSubarray();

        System.out.println(largestSumSubarray.maxSubArray(new int[]{2, 3, 5, -2, 7, -4}));
        System.out.println(largestSumSubarray.maxSubArray(new int[]{-2, -3, -7, -2, -10, -4}));
        System.out.println(largestSumSubarray.maxSubArray(new int[]{-1, 2, 3, -1, 2, -6, 5}));
    }

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int s = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {
                s = i;
            }
            sum += nums[i];


            if (maxSum < sum) {
                start = s;
                end = i;
                maxSum = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println(start + "----->" + end);
        return maxSum;
    }
}
