package binary_search.on_answer;

public class NthRoot {
    public static void main(String[] args) {
        NthRoot nthRoot = new NthRoot();
        System.out.println(nthRoot.NthRoot(3, 27));
        System.out.println(nthRoot.NthRoot(4, 69));
        System.out.println(nthRoot.NthRoot(4, 81));
        System.out.println(nthRoot.NthRoot(9, 10077696));
    }

    public int NthRoot(int N, int M) {
        if (M == 0 || M == 1) {
            return M;
        }
        int start = 1;
        int end = M;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;

            int result = calculatePower(N, M, mid);
            if (result == 0) {
                return mid;
            } else if (result == 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private int calculatePower(int n, int val, int num) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= num;
            if (ans > val) {
                return 2;
            }
        }
        return ans == val ? 0 : 1;
    }
}
