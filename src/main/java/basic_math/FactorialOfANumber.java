package basic_math;

public class FactorialOfANumber {
    public static void main(String[] args) {
        FactorialOfANumber factorialOfANumber = new FactorialOfANumber();
        System.out.println(factorialOfANumber.factorial(0));
        System.out.println(factorialOfANumber.factorial(10));

    }

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        int fact = 1;
        for (int i = 2; i <= n ; i++) {
            fact *= i;
        }
        return fact;
    }
}
