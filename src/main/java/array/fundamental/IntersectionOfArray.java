package array.fundamental;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3, 5};
        int[] nums2 = {1, 2, 7};

        IntersectionOfArray intersectionOfArray = new IntersectionOfArray();

        System.out.println(Arrays.toString(intersectionOfArray.intersectionArray(nums1, nums2)));
        System.out.println(Arrays.toString(intersectionOfArray.intersectionArray(new int[]{1, 2, 2, 3}, new int[]{4, 5, 7})));
        System.out.println(Arrays.toString(intersectionOfArray.intersectionArray(new int[]{-45, -45, 0, 0, 2}, new int[]{-50, -45, 0, 0, 5, 7})));
    }

    public int[] intersectionArray(int[] nums1, int[] nums2) {
        List<Integer> al = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums2[j] < nums1[i]) {
                j++;
            } else {
                al.add(nums1[i]);
                i++;
                j++;
            }
        }
        return al.stream().mapToInt(Integer::intValue).toArray();
    }
}
