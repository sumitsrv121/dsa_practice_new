package array.faqs_hard;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public static void main(String[] args) {
        MajorityElementII majorityElementII = new MajorityElementII();

        System.out.println(majorityElementII.majorityElementTwo(new int[]{1, 2, 1, 1, 3, 2, 2}));
    }

    public List<Integer> majorityElementTwo(int[] nums) {
        int majorityEl1 = Integer.MIN_VALUE;
        int majorityEl2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            if (count1 == 0 && majorityEl2 != num) {
                majorityEl1 = num;
                count1 = 1;
            } else if (count2 == 0 && majorityEl1 != num) {
                majorityEl2 = num;
                count2 = 1;
            } else if (majorityEl1 == num) {
                count1++;
            } else if (majorityEl2 == num) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == majorityEl1) {
                count1++;
            } else if (num == majorityEl2) {
                count2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        int n = nums.length / 3;

        if (count1 > n) {
            result.add(majorityEl1);
        }

        if (count2 > n) {
            result.add(majorityEl2);
        }
        return result;
    }
}
