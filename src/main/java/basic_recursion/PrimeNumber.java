package basic_recursion;

public class PrimeNumber {
    public static void main(String[] args) {
        PrimeNumber primeNumber = new PrimeNumber();

        System.out.println(primeNumber.checkPrime(10));
        System.out.println(primeNumber.checkPrime(5));
        System.out.println(primeNumber.checkPrime(7));
        System.out.println(primeNumber.checkPrime(11));
        System.out.println(primeNumber.checkPrime(2));
        System.out.println(primeNumber.checkPrime(1));

    }

    public boolean checkPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        return isPrime(num, 2);
    }

    private boolean isPrime(int num, int i) {
        if (i * i > num) {
            return true;
        }
        return num % i != 0 && isPrime(num, i + 1);
    }
}
