package array.faqs_medium;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 5, 7, 9};
        FourSum fSum = new FourSum();
        System.out.println(fSum.fourSum(arr, 7));
        System.out.println(fSum.fourSum(new int[]{1, 1, 3, 4, -3}, 5));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        int i = 0;
        int j;
        int k;
        int l;

        while (i < nums.length - 3) {
            j = i + 1;
            while (j < nums.length - 2) {
                k = j + 1;
                l = nums.length - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        storeQuadruplets(nums[i], nums[j], nums[k], nums[l], result);

                        int kValue = nums[k];
                        while (k < l && nums[k] == kValue) {
                            k++;
                        }

                        int lValue = nums[l];
                        while (k < l && nums[l] == lValue) {
                            l--;
                        }
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
                j = skipDuplicate(nums, nums[j], nums.length -2, j);
            }
            i = skipDuplicate(nums, nums[i], nums.length - 3, i);
        }

        return new ArrayList<>(result);
    }

    private int skipDuplicate(int[] nums, int value, int end, int start) {
        while (start < end && nums[start] == value) {
            start++;
        }
        return start;
    }

    private void storeQuadruplets(int num, int num1, int num2, int num3, Set<List<Integer>> quadruplets) {
        List<Integer> temp = new ArrayList<>();

        temp.add(num);
        temp.add(num1);
        temp.add(num2);
        temp.add(num3);

        // Collections.sort(temp);
        quadruplets.add(temp);
    }

    private ArrayList<List<Integer>> betterSolution(int[] nums, int target) {
        Set<List<Integer>> quadruplets = new HashSet<>();

        Set<Integer> bucket = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                bucket.clear();
                for (int k = j + 1; k < nums.length; k++) {
                    int requiredNum = target - (nums[i] + nums[j] + nums[k]);

                    if (bucket.contains(requiredNum)) {
                        storeQuadruplets(nums[i], nums[j], nums[k], requiredNum, quadruplets);
                    }

                    bucket.add(nums[k]);
                }
            }
        }

        return new ArrayList<>(quadruplets);
    }

    private ArrayList<List<Integer>> bruteForceSolution(int[] nums, int target) {
        Set<List<Integer>> quadruplets = new HashSet<>();

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        int sum = nums[i] + nums[j] + nums[k] + nums[l];

                        if (sum == target) {
                            storeQuadruplets(nums[i], nums[j], nums[k], nums[l], quadruplets);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(quadruplets);
    }
}
