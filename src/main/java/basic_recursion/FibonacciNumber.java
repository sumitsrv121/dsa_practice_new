package basic_recursion;

public class FibonacciNumber {
    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        System.out.println(fibonacciNumber.fib(2));
        System.out.println(fibonacciNumber.fib(3));
        System.out.println(fibonacciNumber.fib(5));
    }

    public int fib(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        return fib(num - 1) + fib(num - 2);
    }
}
