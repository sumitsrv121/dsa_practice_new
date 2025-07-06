package binary_search.faq;

import java.util.Comparator;
import java.util.Optional;
import java.util.PriorityQueue;

public class KthSmallestProductOfTwoSortedArray {
    public static void main(String[] args) {
        KthSmallestProductOfTwoSortedArray smallestProduct = new KthSmallestProductOfTwoSortedArray();

        System.out.println(smallestProduct.kthSmallestProduct(new int[]{2, 5}, new int[]{3, 4}, 2));
        System.out.println(smallestProduct.kthSmallestProduct(new int[]{-4, -2, 0, 3}, new int[]{2, 4}, 6));
        System.out.println(smallestProduct.kthSmallestProduct(new int[]{-2, -1, 0, 1, 2}, new int[]{-3, -1, 2, 4, 5}, 3));
    }

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        if (nums1.length > nums2.length) {
            return kthSmallestProduct(nums2, nums1, k);
        }
        long low = -10000000000L, high = 10000000000L;
        long answer = 0;
        long mid;
        while (low <= high) {
            mid = low + ((high - low) / 2);

            long newK = findK(nums1, nums2, mid);

            if (newK >= k) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    private long findK(int[] nums1, int[] nums2, long maxProduct) {
        long k = 0;
        for (int i = 0; i < nums1.length; i++) {
            int low = 0;
            int high = nums2.length - 1;

            if (nums1[i] > 0) {
                long validSelection = 0;
                int mid;
                long currentProduct;
                while (low <= high) {
                    mid = low + ((high - low) / 2);

                    currentProduct = (long) nums1[i] * nums2[mid];

                    if (currentProduct <= maxProduct) {
                        validSelection = mid + 1;
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                k += validSelection;
            } else if (nums1[i] < 0) {
                long validSelection = nums2.length;
                int mid;
                long currentProduct;

                while (low <= high) {
                    mid = low + ((high - low) / 2);

                    currentProduct = (long) nums1[i] * nums2[mid];

                    if (currentProduct <= maxProduct) {
                        validSelection = mid;
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                k += (nums2.length - validSelection);
            } else {
                if (maxProduct >= 0) {
                    k += nums2.length;
                }
            }
        }
        return k;
    }

    private static Long bruteForce(int[] nums1, int[] nums2, long k) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>((l1, l2) -> Long.compare(l2, l1));

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                maxHeap.add(((long) num1 * num2));

                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        return Optional.ofNullable(maxHeap.peek()).orElse(-1L);
    }
}
