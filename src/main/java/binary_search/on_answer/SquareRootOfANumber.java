package binary_search.on_answer;

public class SquareRootOfANumber {
    public static void main(String[] args) {
        SquareRootOfANumber squareRootOfANumber = new SquareRootOfANumber();
        System.out.println(squareRootOfANumber.floorSqrt(36));
        System.out.println(squareRootOfANumber.floorSqrt(28));
        System.out.println(squareRootOfANumber.floorSqrt(50));

    }

    public long floorSqrt(long n) {
        if (n == 0 || n == 1) {
            return n;
        }

        long low = 1;
        long high = n;
        long mid;
        long ans = -1;

        while (low <= high) {
            mid = low + ((high - low) / 2);

            if (mid * mid <= n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
