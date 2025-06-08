package basic_math;

public class GCD {
    public static void main(String[] args) {
        GCD gcd = new GCD();
        System.out.println(gcd.GCD(4, 6));
        System.out.println(gcd.GCD(9, 8));
        System.out.println(gcd.GCD(6, 12));
    }

    public int GCD(int n1, int n2) {
        int num1 = Math.min(n1, n2);
        int num2 = Math.max(n1, n2);

        while(num2 % num1 != 0) {
            int temp = num2;
            num2 = num1;
            num1 = temp % num1;
        }
        return num1;
    }
}
