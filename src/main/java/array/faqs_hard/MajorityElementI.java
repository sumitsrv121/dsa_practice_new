package array.faqs_hard;

public class MajorityElementI {
    public static void main(String[] args) {
        int[] nums = {7, 0, 0, 1, 7, 7, 2, 7, 7};

        MajorityElementI majorityElementI = new MajorityElementI();
        //System.out.println(majorityElementI.majorityElement(nums));
        //System.out.println(majorityElementI.majorityElement(new int[]{1, 1, 1, 2, 1, 2}));
        //System.out.println(majorityElementI.majorityElement(new int[]{-1, -1, -1, -1}));
        System.out.println(majorityElementI.majorityElement(new int[]{86, 100, 54, 81, 27, 65, 65, 97, 72, 25, 43, 65, 13, 44, 93, 65, 46, 65, 67, 56, 85, 65, 65, 65, 65, 65, 65, 65, 65, 7, 65, 65, 31, 51, 65, 65, 65, 65, 65, 67, 65, 65, 62, 65, 65, 65, 12, 65, 55, 96, 65, 65, 4, 66, 37, 65, 80, 40, 91, 65, 65, 28, 68, 58, 65, 65, 65, 65, 58, 65, 65, 12, 48, 89, 65, 65, 65, 65, 16, 41, 65, 52, 65, 65, 25, 65, 65, 65, 36, 65, 65, 70, 65, 19, 20, 65}));
    }

    public int majorityElement(int[] nums) {
        int majorityEl = Integer.MIN_VALUE;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                majorityEl = num;
                count = 1;
            } else if (majorityEl == num) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int num : nums) {
            if (num == majorityEl) {
                count++;
            }
        }
        if (count > nums.length / 2) {
            return majorityEl;
        }
        return -1;
    }


}
