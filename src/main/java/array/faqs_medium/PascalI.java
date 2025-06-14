package array.faqs_medium;

public class PascalI {
    public static void main(String[] args) {
        PascalI pascalI = new PascalI();
        System.out.println(pascalI.pascalTriangleI(4, 2));
    }

    public int pascalTriangleI(int r, int c) {
        return findNCR(r - 1, c - 1);
    }

    private int findNCR(int n, int r) {
        int product = 1;
        for (int i = 1; i <= r; i++) {
            product *= (n - i + 1);
            product /= i;
        }

        return product;
    }
}
