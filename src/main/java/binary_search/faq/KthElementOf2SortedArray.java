package binary_search.faq;

public class KthElementOf2SortedArray {
    public static void main(String[] args) {
        KthElementOf2SortedArray kthElementOf2SortedArray = new KthElementOf2SortedArray();
        System.out.println(kthElementOf2SortedArray.kthElement(new int[]{2, 3, 6, 7, 9}, new int[]{1, 4, 8, 10}, 5));
        System.out.println(kthElementOf2SortedArray.kthElement(new int[]{100, 112, 256, 349, 770}, new int[]{72, 86, 113, 119, 265, 445, 892}, 7));
        System.out.println(kthElementOf2SortedArray.kthElement(new int[]{2, 3, 6}, new int[]{7, 9}, 4));
    }

    public int kthElement(int[] a, int[] b, int k) {
        if (a.length > b.length) {
            return kthElement(b, a, k);
        }
        int n1 = a.length;
        int n2 = b.length;

        int low = Math.max(0, k - n2);
        int high = Math.min(k, n1);
        int mid1;
        int mid2;

        while (low <= high) {
            mid1 = low + ((high - low) / 2);
            mid2 = k - mid1;
            int l1 = mid1 - 1 >= 0 ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = mid2 - 1 >= 0 ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = mid1 < n1 ? a[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < n2 ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return -1;
    }
}
