package array.faqs_hard;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        //System.out.println(maximumProductSubarray.maxProduct(new int[]{4, 5, 3, 7, 1, 2}));
        //System.out.println(maximumProductSubarray.maxProduct(new int[]{-5, 0, -2}));
        System.out.println(maximumProductSubarray.maxProduct(new int[]{1, -2, 3, 4, -4, -3}));
    }

    public int maxProduct(int[] nums) {
        int prefixProduct = 1;
        int suffixProduct = 1;
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            prefixProduct *= nums[i];
            suffixProduct *= nums[nums.length - 1 - i];

            maxProduct = Math.max(maxProduct, Math.max(prefixProduct, suffixProduct));

            if (prefixProduct == 0) {
                prefixProduct = 1;
            }

            if (suffixProduct == 0) {
                suffixProduct = 1;
            }
        }
        return maxProduct;
    }

    private static int bruteForceSolution(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int currentProduct;
        for (int i = 0; i < nums.length; i++) {
            currentProduct = 1;
            for (int j = i; j < nums.length; j++) {
                currentProduct *= nums[j];
                maxProduct = Math.max(maxProduct, currentProduct);
            }
        }

        return maxProduct;
    }
}
