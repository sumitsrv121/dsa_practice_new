package basic_math;

public class ReverseNumber {
    public static void main(String[] args) {
        ReverseNumber rn = new ReverseNumber();
        System.out.println(rn.reverseNumber(123));
    }

    public int reverseNumber(int n) {
        int newN = 0;

        while (n > 0) {
            int lastDigit = n % 10;
            newN = (newN * 10) + lastDigit;
            n /= 10;
        }
        return newN;
    }
}
