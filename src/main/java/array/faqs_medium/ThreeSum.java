package array.faqs_medium;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum tSum = new ThreeSum();


        System.out.println(tSum.threeSum(new int[]{2, -2, 0, 3, -3, 5}));
        //System.out.println(tSum.threeSum(new int[]{2, -1, -1, 3, -1}));
        //System.out.println(tSum.threeSum(new int[]{8, -6, 5, 4}));
        //System.out.println(tSum.threeSum(new int[]{-374, -329, -194, -730, -275, -241, -936, -928, 141, -463, 160, -93, -325, 278, -600, -13, -313, -900, -269, -602, -878, -917, -359, -617, 741, -143, 562, -705, -306, -396, 932, -479, -977, -243, -633, -364, 240, -896, -529, -557, -541, -55, 585, -690, -969, -789, 879, 433, 622, -479, -501, -735, -470, -817}));


    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> triplets = new HashSet<>();
        Arrays.sort(nums);
        int i = 0;
        int j;
        int k;

        while (i < nums.length - 2) {
            j = i + 1;
            k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    storeTriplet(nums, i, k, nums[j], triplets);

                    int jVal = nums[j];
                    while (j < k && jVal == nums[j]) {
                        j++;
                    }

                    int kVal = nums[k];
                    while (j < k && kVal == nums[k]) {
                        k--;
                    }
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }

            int iVal = nums[i];
            while (i < nums.length - 2 && iVal == nums[i]) {
                i++;
            }
        }
        return new ArrayList<>(triplets);
    }

    private static void storeTriplet(int[] nums, int i, int j, int target, Set<List<Integer>> triplets) {
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[i]);
        temp.add(target);
        temp.add(nums[j]);
        Collections.sort(temp);

        triplets.add(temp);
    }

    private static ArrayList<List<Integer>> betterSolution(int[] nums) {
        Set<Integer> bucket = new HashSet<>();

        Set<List<Integer>> triplets = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            bucket.clear();
            for (int j = i + 1; j < nums.length; j++) {
                int target = -(nums[i] + nums[j]);
                if (bucket.contains(target)) {
                    storeTriplet(nums, i, j, target, triplets);
                }
                bucket.add(nums[j]);
            }
        }
        return new ArrayList<>(triplets);
    }

    private static ArrayList<List<Integer>> bruteForceSolution(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplets = new ArrayList<>();
                        triplets.add(nums[i]);
                        triplets.add(nums[j]);
                        triplets.add(nums[k]);
                        ans.add(triplets.stream().sorted().collect(Collectors.toList()));
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
