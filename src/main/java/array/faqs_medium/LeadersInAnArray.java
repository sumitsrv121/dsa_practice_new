package array.faqs_medium;

import java.util.ArrayList;

public class LeadersInAnArray {
    public static void main(String[] args) {
        LeadersInAnArray leadersInAnArray = new LeadersInAnArray();
        System.out.println(leadersInAnArray.leaders(new int[]{1, 2, 5, 3, 1, 2}));
        System.out.println(leadersInAnArray.leaders(new int[]{-3, 4, 5, 1, -4, -5}));
        System.out.println(leadersInAnArray.leaders(new int[]{-3, 4, 5, 1, -30, -10}));
    }

    public ArrayList<Integer> leaders(int[] nums) {
        ArrayList<Integer> leadersList = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (leadersList.isEmpty()) {
                leadersList.add(nums[i]);
            } else if (leadersList.get(0) < nums[i]) {
                leadersList.add(0, nums[i]);
            }
        }


        return leadersList;
    }
}
