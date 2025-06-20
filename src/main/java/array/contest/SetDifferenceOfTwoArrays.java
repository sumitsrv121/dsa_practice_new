package array.contest;

import java.util.*;

public class SetDifferenceOfTwoArrays {
    public static void main(String[] args) {
        SetDifferenceOfTwoArrays setDifferenceOfTwoArrays = new SetDifferenceOfTwoArrays();

        //System.out.println(Arrays.toString(setDifferenceOfTwoArrays.setDifference(new int[]{1, 5, 7, 9}, new int[]{1, 3, 4, 7})));
        //System.out.println(Arrays.toString(setDifferenceOfTwoArrays.setDifference(new int[]{1, 2, 6, 6}, new int[]{-2, 2, 3, 4, 6})));
        System.out.println(Arrays.toString(setDifferenceOfTwoArrays
                .setDifference(new int[]{-17, -14, -14, -10, 2, 3, 5, 9, 21, 21, 26},
                        new int[]{-23, -22, -22, -22, -22, -21, -20, -20, -18, -16, -13, -13, -11, -11, -11, -5, 1, 1, 2, 5, 5, 9, 10, 10, 11, 12, 12, 12, 13, 14, 17, 20, 21, 21, 22})));

    }

    public int[] setDifference(int[] nums1, int[] nums2) {
        int left = 0;
        int right = 0;

        List<Integer> uniqueList = new ArrayList<>();
        Set<Integer> ignoredNums = new HashSet<>();

        while (left < nums1.length && right < nums2.length) {
            if (nums1[left] == nums2[right]) {
                // both are equal ignore the number
                ignoredNums.add(nums1[left]);
                left++;
                right++;
            } else if (nums1[left] < nums2[right]) {
                if ((uniqueList.isEmpty()
                        || uniqueList.get(uniqueList.size() - 1) != nums1[left])
                        && !ignoredNums.contains(nums1[left])) {
                    uniqueList.add(nums1[left]);
                }
                left++;
            } else {
                if ((uniqueList.isEmpty()
                        || uniqueList.get(uniqueList.size() - 1) != nums2[right])
                        && !ignoredNums.contains(nums2[right])) {
                    uniqueList.add(nums2[right]);
                }
                right++;
            }
        }

        while (left < nums1.length) {
            if ((uniqueList.isEmpty()
                    || (uniqueList.get(uniqueList.size() - 1) != nums1[left]
                    && nums1[left] != nums2[nums2.length - 1]))
                    && !ignoredNums.contains(nums1[left])) {
                uniqueList.add(nums1[left]);
            }
            left++;
        }

        while (right < nums2.length) {
            if ((uniqueList.isEmpty()
                    || (uniqueList.get(uniqueList.size() - 1) != nums2[right]
                    && nums2[right] != nums1[nums1.length - 1]))
                    && !ignoredNums.contains(nums2[right])) {
                uniqueList.add(nums2[right]);
            }
            right++;
        }

        return uniqueList.stream().mapToInt(Integer::intValue).toArray();
    }
}
