package array.faqs_hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RepeatingAndMissingNumber {
    public static void main(String[] args) {
        RepeatingAndMissingNumber repeatingAndMissingNumber = new RepeatingAndMissingNumber();

        System.out.println(Arrays.toString(repeatingAndMissingNumber.findMissingRepeatingNumbers(new int[]{4, 3, 6, 2, 1, 1})));
        System.out.println(Arrays.toString(repeatingAndMissingNumber.findMissingRepeatingNumbers(new int[]{3, 5, 4, 1, 1})));
        System.out.println(Arrays.toString(repeatingAndMissingNumber.findMissingRepeatingNumbers(new int[]{1, 2, 3, 6, 7, 5, 7})));
        System.out.println(Arrays.toString(repeatingAndMissingNumber.findMissingRepeatingNumbers(new int[]{6, 5, 7, 1, 8, 6, 4, 3, 2})));
    }

    public int[] findMissingRepeatingNumbers(int[] nums) {
        int s = 0;
        int sn = 0;

        // find (x - y)
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            s -= (i + 1);
        }

        // find (x^2 - y^2)
        for (int i = 0; i < nums.length; i++) {
            sn += (nums[i] * nums[i]);
            sn -= ((i + 1) * (i + 1));
        }

        // find (x + y)
        int xAndY = sn / s;

        int x = (xAndY + s) / 2;
        int y = x - s;

        return new int[]{x, y};
    }

    private int[] betterSolution(int[] nums) {
        int repeatingNumber = findRepeatingNumber(nums);
        int missingNumber = findMissingNumber(nums, repeatingNumber);

        return new int[]{repeatingNumber, missingNumber};
    }

    public int findRepeatingNumber(int[] nums) {
        Set<Integer> seenNumbers = new HashSet<>();

        for (int num : nums) {
            if (!seenNumbers.contains(num)) {
                seenNumbers.add(num);
            } else {
                return num;
            }
        }
        throw new RuntimeException("No missing number found");
    }

    public int findMissingNumber(int[] arr, int repeatingNumber) {
        int xorOfIndex = 0;
        int xorOfNumber = 0;
        boolean hasRepeatingNumberFound = false;

        for (int i = 0; i < arr.length; i++) {
            xorOfIndex ^= (i + 1);
            if (!hasRepeatingNumberFound || repeatingNumber != arr[i]) {
                xorOfNumber ^= arr[i];
            }

            if (repeatingNumber == arr[i]) {
                hasRepeatingNumberFound = true;
            }
        }

        return xorOfIndex ^ xorOfNumber;
    }
}
