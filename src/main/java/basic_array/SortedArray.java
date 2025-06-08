package basic_array;

public class SortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 1};
        SortedArray sortedArray = new SortedArray();
        System.out.println(sortedArray.arraySortedOrNot(arr, arr.length));
    }

    boolean arraySortedOrNot(int[] arr, int n) {
        int i = 0;
        int j = 1;

        while (j < n) {
            if (arr[i++] > arr[j++]) {
                return false;
            }
        }
        return true;
    }
}
