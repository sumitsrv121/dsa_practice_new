package basic_hashing;

import java.util.HashMap;
import java.util.Map;

public class SecondHighestOccurringElement {
    public static void main(String[] args) {
        int[] arr = {7131, 7131, 7564, 3049, 3817, 956, 2059, 3452, 3466, 4087, 9866, 2622, 5499, 2761, 1946, 8131, 3103, 909, 9815, 9410, 7124, 2831, 3434, 3986, 2694, 7245, 1594, 5498, 2130, 5710, 3956, 1845, 3063, 2606, 1379, 3397};
        SecondHighestOccurringElement secondHighestOccurringElement = new SecondHighestOccurringElement();
        System.out.println(secondHighestOccurringElement.secondMostFrequentElement(arr));
    }

    public int secondMostFrequentElement(int[] nums) {
        Map<Integer, Integer> occurrenceMap = new HashMap<>();

        for (int num : nums) {
            occurrenceMap.merge(num, 1, Integer::sum);
        }

        int secondEl = -1;
        int firstEl = -1;
        int maxOccurrence = Integer.MIN_VALUE;
        int secondMaxOccurrence = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : occurrenceMap.entrySet()) {
            int el = entry.getKey();
            int occurrence = entry.getValue();

            if (maxOccurrence < occurrence) {
                secondMaxOccurrence = maxOccurrence;
                maxOccurrence = occurrence;
                secondEl = firstEl;
                firstEl = el;
            } else if (maxOccurrence == occurrence) {
                firstEl = Math.min(firstEl, el);
            } else if (secondMaxOccurrence < occurrence) {
                secondMaxOccurrence = occurrence;
                secondEl = el;
            } else if (secondMaxOccurrence == occurrence) {
                secondEl = Math.min(secondEl, el);
            }
        }

        return secondEl;
    }
}
