package array.faqs_hard;

import java.util.Arrays;

public class MergeTwoSortedArrayWithoutExtraSpace {
    public static void main(String[] args) {
        MergeTwoSortedArrayWithoutExtraSpace mergeTwoSortedArrayWithoutExtraSpace =
                new MergeTwoSortedArrayWithoutExtraSpace();

        int[] nums1 = {-5, -2, 4, 5, 0, 0, 0};
        int[] nums2 = {-3, 1, 8};
        //mergeTwoSortedArrayWithoutExtraSpace.merge(nums1, nums1.length - nums2.length, nums2, nums2.length);
        mergeTwoSortedArrayWithoutExtraSpace.mergeWithGapAlgorithm(nums1, nums1.length - nums2.length, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int start = m - 1;
        int end = 0;

        while (start >= 0 && end < n && nums1[start] > nums2[end]) {
            swap(nums1, nums2, start, end);
            start--;
            end++;
        }

        Arrays.sort(nums1, 0, m);
        Arrays.sort(nums2);

        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }

    }

    public void swap(int[] nums1, int[] nums2, int i, int j) {
        int temp = nums1[i];
        nums1[i] = nums2[j];
        nums2[j] = temp;
    }

    public void mergeWithGapAlgorithm(int[] nums1, int m, int[] nums2, int n) {
        int totalLength = (m + n);
        int gap;

        int left;
        int right;

        do {
            double average = (double) totalLength / 2;
            gap = (int) Math.ceil(average);

            left = 0;
            right = left + gap;

            while (right < m + n) {
                if (left < m && right < m) {
                    if (nums1[left] > nums1[right]) {
                        swap(nums1, nums1, left, right);
                    }
                } else if (left < m && right >= m) {
                    if (nums1[left] > nums2[right - m]) {
                        swap(nums1, nums2, left, right - m);
                    }
                } else if (left >= m && right >= m) {
                    if (nums2[left - m] > nums2[right - m]) {
                        swap(nums2, nums2, left - m, right - m);
                    }
                }
                left++;
                right++;
            }

            totalLength = gap;

        } while (gap != 1);

        for (int i = m, j =0; i < m+n; i++, j++) {
            nums1[i] = nums2[j];
        }
    }
}
