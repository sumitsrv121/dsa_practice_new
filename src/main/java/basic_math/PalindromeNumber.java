package basic_math;

public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        System.out.println(pn.isPalindrome(121));
    }

    public boolean isPalindrome(int n) {
        String num = String.valueOf(n);

        int start = 0;
        int end = num.length() - 1;

        while (start < end) {
            if (num.charAt(start++) != num.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
