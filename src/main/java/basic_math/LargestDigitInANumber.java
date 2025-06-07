package basic_math;

public class LargestDigitInANumber {
    public static void main(String[] args) {
        LargestDigitInANumber largestDigitInANumber = new LargestDigitInANumber();

        System.out.println(largestDigitInANumber.largestDigit(25));
    }

    public int largestDigit(int n) {
        if (n == 0) {
            return 0;
        }
        int maxDigit = Integer.MIN_VALUE;

        while (n > 0) {
            int digit = n % 10;
            maxDigit = Math.max(maxDigit, digit);
            n /= 10;
        }
        return maxDigit;
    }
}
