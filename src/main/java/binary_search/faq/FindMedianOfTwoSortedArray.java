package binary_search.faq;

public class FindMedianOfTwoSortedArray {
    public static void main(String[] args) {
        FindMedianOfTwoSortedArray findMedian = new FindMedianOfTwoSortedArray();
        System.out.println(findMedian.median(new int[]{2, 4, 6}, new int[]{1, 3, 5}));
        System.out.println(findMedian.median(new int[]{2, 4, 6}, new int[]{1, 3}));
        System.out.println(findMedian.median(new int[]{2, 4, 5}, new int[]{1, 6}));
    }

    public double median(int[] arr1, int[] arr2) {
        return arr1.length <= arr2.length ? findMedian(arr1, arr2) : findMedian(arr2, arr1);
    }

    private double findMedian(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n = n1 + n2 + 1;

        int k = n / 2;

        int low = 0;
        int high = n1;
        int mid1;
        int mid2;

        while (low <= high) {
            mid1 = low + ((high - low) / 2);
            mid2 = k - mid1;

            int l1 = mid1 - 1 < 0 ? Integer.MIN_VALUE : arr1[mid1 - 1];
            int l2 = mid2 - 1 < 0 ? Integer.MIN_VALUE : arr2[mid2 - 1];
            int r1 = mid1 >= n1 ? Integer.MAX_VALUE : arr1[mid1];
            int r2 = mid2 >= n2 ? Integer.MAX_VALUE : arr2[mid2];

            if (l1 <= r2 && l2 <= r1) {
                return (n - 1) % 2 == 0 ? (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0 : (Math.max(l1, l2));
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;
    }
}
