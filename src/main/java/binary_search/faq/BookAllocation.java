package binary_search.faq;

public class BookAllocation {
    public static void main(String[] args) {
        BookAllocation bookAllocation = new BookAllocation();
        System.out.println(bookAllocation.findPages(new int[] {15, 17, 20}, 2));
    }

    public int findPages(int[] nums, int m) {
        if (nums == null || nums.length == 0 || m > nums.length) {
            return -1;
        }

        MaxAndSum maxAndSum = findMaxAndSum(nums);
        long start = maxAndSum.max;
        long end = maxAndSum.sum;
        long mid;
        int ans = -1;

        while (start <= end) {
            mid = (start + end) / 2;

            long numberOfStudents = findNumberOfStudents(nums, mid);

            if (numberOfStudents <= m) {
                ans = (int) mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public long findNumberOfStudents(int[] nums, long maxPages) {
        long pagesCount = 0;
        long noOfStudents = 1;

        for (int num : nums) {
            if (pagesCount + num <= maxPages) {
                pagesCount += num;
            } else {
                pagesCount = num;
                noOfStudents++;
            }
        }
        return noOfStudents;
    }

    public MaxAndSum findMaxAndSum(int[] nums) {
        long sum = 0;
        long max = Long.MIN_VALUE;

        for (int num : nums) {
            sum += num;

            if (max < num) {
                max = num;
            }
        }
        return new MaxAndSum(max, sum);
    }

    public record MaxAndSum(long max, long sum) {
    }
}
