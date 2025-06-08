package basic_hashing;

import java.util.HashMap;
import java.util.Map;

public class SumOfHighestAndLowestFrequency {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3};
        SumOfHighestAndLowestFrequency sumOfHighestAndLowestFrequency = new SumOfHighestAndLowestFrequency();

        System.out.println(sumOfHighestAndLowestFrequency.sumHighestAndLowestFrequency(arr));
    }

    public int sumHighestAndLowestFrequency(int[] nums) {
        Map<Integer, Integer> occurrenceMap = new HashMap<>();

        for (int num : nums) {
            occurrenceMap.merge(num, 1, Integer::sum);
        }

        int maxOccurrence = Integer.MIN_VALUE;
        int minOccurrence = Integer.MAX_VALUE;


        for (Map.Entry<Integer, Integer> entry : occurrenceMap.entrySet()) {
            int occurrence = entry.getValue();

            if (maxOccurrence < occurrence) {
                maxOccurrence = occurrence;
            }

            if (minOccurrence > occurrence) {
                minOccurrence = occurrence;
            }
        }
        return maxOccurrence + minOccurrence;
    }
}
