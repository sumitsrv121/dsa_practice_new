package array.fundamental;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionOfArray {
    public static void main(String[] args) {
        int[] nums1 = {0, 1, 1, 1, 2, 3, 4};
        int[] nums2 = {1, 2, 2, 2, 3, 3, 4};
        System.out.println(Arrays.toString(new UnionOfArray().unionArray(nums1, nums2)));
        System.out.println(Arrays.toString(new UnionOfArray().unionArray(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 7})));
        System.out.println(Arrays.toString(new UnionOfArray().unionArray(new int[]{3, 4, 6, 7, 9, 9}, new int[]{1, 5, 7, 8, 8})));
        System.out.println(Arrays.toString(new UnionOfArray().unionArray(new int[]{3, 6, 8, 13, 21, 30, 30, 35, 37, 40, 43}, new int[]{1, 2, 3, 3, 4, 6, 7, 8, 13, 13, 14, 15, 15, 20, 21, 27, 28, 30, 30, 30, 33, 34, 36, 37, 38, 38, 42, 43, 47, 49, 50})));
    }

    public int[] unionArray(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;

        List<Integer> al = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                if (!al.isEmpty() && nums1[i] == al.get(al.size() - 1)) {
                    i++;
                } else {
                    al.add(nums1[i++]);
                }
            } else if (nums2[j] < nums1[i]) {
                if (!al.isEmpty() && nums2[j] == al.get(al.size() - 1)) {
                    j++;
                } else {
                    al.add(nums2[j++]);
                }
            } else {
                if (al.isEmpty() || nums1[i] != al.get(al.size() - 1)) {
                    al.add(nums1[i]);
                }
                i++;
                j++;
            }
        }

        while (i < nums1.length) {
            if (!al.isEmpty() && al.get(al.size() - 1) != nums1[i]) {
                al.add(nums1[i]);
            }
            i++;
        }

        while (j < nums2.length) {
            if (!al.isEmpty() && al.get(al.size() - 1) != nums2[j]) {
                al.add(nums2[j]);
            }
            j++;
        }

        return al.stream().mapToInt(Integer::intValue).toArray();
    }
}
