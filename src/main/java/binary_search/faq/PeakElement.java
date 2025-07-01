package binary_search.faq;

public class PeakElement {
    public static void main(String[] args) {
        PeakElement peakElement = new PeakElement();
        System.out.println(peakElement.findPeakElement(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 5, 1}));
        System.out.println(peakElement.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
        System.out.println(peakElement.findPeakElement(new int[]{-2, -1, 3, 4, 5}));
    }

    public int findPeakElement(int[] arr) {
        int n = arr.length;
        if (n == 0 || n == 1) {
            return 0;
        }

        // Peak at left side
        if (arr[0] > arr[1]) {
            return 0;
        }

        // Peak at right most side
        if (arr[n - 1] > arr[n - 2]) {
            return n - 1;
        }

        int start = 1;
        int end = n - 2;
        int mid;

        while (start <= end) {
            mid = start + ((end - start) / 2);

            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
            } else if (arr[mid] <= arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }
}
