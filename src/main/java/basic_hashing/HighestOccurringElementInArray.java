package basic_hashing;

import java.util.HashMap;
import java.util.Map;

public class HighestOccurringElementInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 2, 2, 1, 3, 4};

        HighestOccurringElementInArray highestOccurringElementInArray = new HighestOccurringElementInArray();
        System.out.println(highestOccurringElementInArray.mostFrequentElement(arr));
    }

    public int mostFrequentElement(int[] nums) {
        int maxOccurrence = Integer.MIN_VALUE;
        int element = Integer.MAX_VALUE;
        Map<Integer, Integer> occurrenceMap = new HashMap<>();
        for (int el : nums) {
            occurrenceMap.merge(el, 1, Integer::sum);

            if(maxOccurrence < occurrenceMap.get(el)) {
                maxOccurrence = occurrenceMap.get(el);
                element = el;
            } else if(maxOccurrence == occurrenceMap.get(el)) {
                element = Math.min(el, element);
            }
        }
        return element;
    }
}
