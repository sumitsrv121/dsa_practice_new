package array.logic_building;

public class MissingElement {
    public static void main(String[] args) {
        MissingElement missingElement = new MissingElement();

        System.out.println(missingElement.missingNumber(new int[]{0, 2, 3, 1, 4}));
        System.out.println(missingElement.missingNumber(new int[]{0, 1, 2, 4, 5, 6}));
        System.out.println(missingElement.missingNumber(new int[]{1, 3, 6, 4, 2, 5}));
    }

    public int missingNumber(int[] nums) {
        int xor1 = 0;
        int xor2 = 0;
        for (int i = 0; i < nums.length; i++) {
            xor1 ^= (i + 1);
            xor2 ^= nums[i];
        }

        return xor1 ^ xor2;
    }
}
