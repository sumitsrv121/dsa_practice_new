package array.faqs_medium;

import java.util.Arrays;

public class RearrangeElementsWithSign {
    public static void main(String[] args) {
        RearrangeElementsWithSign rearrangeElementsWithSign =
                new RearrangeElementsWithSign();
        System.out.println(Arrays.toString(rearrangeElementsWithSign.rearrangeArray(new int[]{2, 4, 5, -1, -3, -4})));
        System.out.println(Arrays.toString(rearrangeElementsWithSign.rearrangeArray(new int[]{1, -1, -3, -4, 2, 3})));
        System.out.println(Arrays.toString(rearrangeElementsWithSign.rearrangeArray(new int[]{-4, 4, -4, 4, -4, 4})));
    }

    public int[] rearrangeArray(int[] nums) {
        int[] arr = new int[nums.length];

        int positiveIndex = 0;
        int negativeIndex = 0;

        for (int el : nums) {
            if (el < 0) {
                arr[2 * negativeIndex + 1] = el;
                negativeIndex++;
            } else {
                arr[2 * positiveIndex] = el;
                positiveIndex++;
            }
        }
        return arr;
    }
}
