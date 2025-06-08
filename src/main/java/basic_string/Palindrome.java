package basic_string;

public class Palindrome {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.palindromeCheck("hannah"));
        System.out.println(palindrome.palindromeCheck("aabbaaa"));
        System.out.println(palindrome.palindromeCheck("aabbccbbaa"));
    }

    public boolean palindromeCheck(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
