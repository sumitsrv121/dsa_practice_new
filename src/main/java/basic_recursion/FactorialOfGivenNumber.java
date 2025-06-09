package basic_recursion;

public class FactorialOfGivenNumber {
    public static void main(String[] args) {
        FactorialOfGivenNumber factorialOfGivenNumber = new FactorialOfGivenNumber();
        System.out.println(factorialOfGivenNumber.factorial(10));
    }

    public long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
