package hashing;

import java.util.*;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        LongestConsecutiveSubsequence longestConsecutiveSubsequence = new LongestConsecutiveSubsequence();

        System.out.println(longestConsecutiveSubsequence.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutiveSubsequence.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(longestConsecutiveSubsequence.longestConsecutive(new int[]{1, 9, 3, 10, 4, 20, 2}));

    }


    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num: nums) {
            set.add(num);
        }

        int currentElement;
        int maxCount = 0;
        int count;

        for (int el: set) {
           if (!set.contains(el - 1)) {
               count = 1;
               currentElement = el;

               while(set.contains(currentElement + 1)) {
                   count ++;
                   currentElement++;
               }

               maxCount = Math.max(count, maxCount);
           }
        }
        return maxCount;
    }

    private static int betterSolution(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int count = 0;
        int maxCount = Integer.MIN_VALUE;
        int currentEl = Integer.MIN_VALUE;

        for (int num : set) {
            if (currentEl == Integer.MIN_VALUE) {
                count++;
            } else {
                if (currentEl + 1 == num) {
                    count++;
                } else {
                    count = 1;
                }
            }
            currentEl = num;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
