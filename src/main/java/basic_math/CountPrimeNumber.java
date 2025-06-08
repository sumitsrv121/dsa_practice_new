package basic_math;

public class CountPrimeNumber {
    public static void main(String[] args) {
        CountPrimeNumber countPrimeNumber = new CountPrimeNumber();
        System.out.println(countPrimeNumber.primeUptoN(10));
    }

    public int primeUptoN(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                count += 1;
            }
        }
        return count;
    }

    public boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
