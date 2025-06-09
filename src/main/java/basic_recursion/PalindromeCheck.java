package basic_recursion;

public class PalindromeCheck {
    public static void main(String[] args) {
        PalindromeCheck palindromeCheck = new PalindromeCheck();
        System.out.println(palindromeCheck.palindromeCheck("hannah"));
        System.out.println(palindromeCheck.palindromeCheck("hannnah"));
        System.out.println(palindromeCheck.palindromeCheck("tree"));
        System.out.println(palindromeCheck.palindromeCheck("nitin"));

    }

    public boolean palindromeCheck(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }

    private boolean isPalindrome(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        return s.charAt(start) == s.charAt(end) && isPalindrome(s, start + 1, end - 1);
    }
}
