package basic_math;

public class PerfectNumber {
    public static void main(String[] args) {
        PerfectNumber perfectNumber = new PerfectNumber();
        System.out.println(perfectNumber.isPerfect(6));
        System.out.println(perfectNumber.isPerfect(4));
        System.out.println(perfectNumber.isPerfect(28));

    }

    public boolean isPerfect(int n) {
        if (n == 1) {
            return false;
        }
        int sum = 1;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;

                if (i != n / i) {
                    sum += n / i;
                }
            }
        }
        return sum == n;
    }
}
