package basic_math;

public class LCM {
    public static void main(String[] args) {
        LCM lcm = new LCM();
        System.out.println(lcm.LCM(4, 6));
    }

    public int LCM(int n1, int n2) {
        int num = Math.max(n1, n2);

        while (num % n1 != 0 || num % n2 != 0) {
            num++;
        }
        return num;
    }
}
