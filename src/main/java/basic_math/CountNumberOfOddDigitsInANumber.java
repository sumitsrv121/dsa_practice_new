package basic_math;

public class CountNumberOfOddDigitsInANumber {
    public static void main(String[] args) {
        CountNumberOfOddDigitsInANumber countNumberOfOddDigitsInANumber = new
                CountNumberOfOddDigitsInANumber();

        System.out.println(countNumberOfOddDigitsInANumber.countOddDigit(15));
    }

    public int countOddDigit(int n) {
        int count = 0;
        while (n > 0) {
            if ((n % 10) % 2 != 0) {
                count++;
            }
            n /= 10;
        }
        return count;
    }
}
