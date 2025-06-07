package basic_math;

public class CountAllDigitsOfANumber {
    public static void main(String[] args) {
        CountAllDigitsOfANumber countAllDigitsOfANumber = new CountAllDigitsOfANumber();
        System.out.println(countAllDigitsOfANumber.countDigit(234));
    }

    public int countDigit(int n) {
        if (n == 0) {
            return 1;
        }

        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }
}
