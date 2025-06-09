package basic_recursion;

public class SumOfArrayElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 10, 3, 4, 5};
        SumOfArrayElements sumOfArrayElements = new SumOfArrayElements();
        System.out.println(sumOfArrayElements.arraySum(arr));
    }

    public int arraySum(int[] nums) {
        return arraySumRecursion(nums, nums.length - 1);
    }

    private int arraySumRecursion(int[] nums, int i) {
        if (i == 0) {
            return nums[0];
        }
        return nums[i] + arraySumRecursion(nums, i - 1);
    }
}
