package array.fundamental;

public class SecondLargestElement {
    public static void main(String[] args) {
        SecondLargestElement sle = new SecondLargestElement();

        System.out.println(sle.secondLargestElement(new int[]{8, 8, 7, 6, 5}));
    }

    public int secondLargestElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                secondMax = max;
                max = nums[i];
            } else if (max > nums[i] && secondMax < nums[i]) {
                secondMax = nums[i];
            }
        }

        return secondMax == Integer.MIN_VALUE ? -1 : secondMax;
    }
}
