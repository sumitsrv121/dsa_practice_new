package basic_math;

public class ArmstrongNumber {
    public static void main(String[] args) {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();
        System.out.println(armstrongNumber.isArmstrong(153));
        System.out.println(armstrongNumber.isArmstrong(12));
        System.out.println(armstrongNumber.isArmstrong(370));

    }

    public boolean isArmstrong(int n) {
        int len = ((int) Math.log10(n)) + 1;
        int existingNumber = n;
        int sum = 0;
        while (n > 0) {
            sum += ((int) Math.pow(n % 10, len));
            n /= 10;
        }

        return  existingNumber == sum;
    }
}
