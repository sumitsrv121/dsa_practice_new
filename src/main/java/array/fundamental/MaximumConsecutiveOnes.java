package array.fundamental;

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 1, 1, 1, 0};
        MaximumConsecutiveOnes mco = new MaximumConsecutiveOnes();
        System.out.println(mco.findMaxConsecutiveOnes(nums));
        System.out.println(mco.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 1, 0, 1, 1, 1}));
        System.out.println(mco.findMaxConsecutiveOnes(new int[]{0, 0, 0, 0, 0, 0, 0, 0}));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxOccurrence = Integer.MIN_VALUE;
        for (int el : nums) {
            if (el == 1) {
                count++;
            } else {
                count = 0;
            }

            if (maxOccurrence < count) {
                maxOccurrence = count;
            }
        }
        return maxOccurrence;
    }
}
