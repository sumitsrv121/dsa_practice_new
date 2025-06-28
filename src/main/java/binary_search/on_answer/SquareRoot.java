package binary_search.on_answer;

public class SquareRoot {
    public static void main(String[] args) {
        SquareRoot squareRoot = new SquareRoot();
        System.out.println(squareRoot.squareRoot(2));
    }

    public double squareRoot(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        double start = 0;
        double end = n;
        double mid;
        double ans = -1;

        while((end - start) > 0.0001) {
            mid = start + ((end - start) / 2);

            double val = mid * mid;
            if (val <= n) {
                ans = mid;
                start = mid;
            } else {
                end = mid;
            }
        }
        return ans;
    }
}
