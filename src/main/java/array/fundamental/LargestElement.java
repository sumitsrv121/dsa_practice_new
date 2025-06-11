package array.fundamental;

public class LargestElement {
    public static void main(String[] args) {
        int[] nums = {3, 3, 0, 99, -40};
        LargestElement le = new LargestElement();

        System.out.println(le.largestElement(nums));
    }

    public int largestElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
