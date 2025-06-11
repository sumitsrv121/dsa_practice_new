package array.fundamental;

public class LinearSearch {
    public static void main(String[] args) {
        LinearSearch ls = new LinearSearch();

        System.out.println(ls.linearSearch(new int[] {2, 3, 4, 5, 3}, 3));
        System.out.println(ls.linearSearch(new int[] {2, 3, 4, 5, 3}, 6));
    }

    public int linearSearch(int nums[], int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
