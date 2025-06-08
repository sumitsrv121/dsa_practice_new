package basic_string;

import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flowers", "flow", "fly", "flight"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"dog", "cat", "animal", "monkey"}));
    }

    public String longestCommonPrefix(String[] str) {
        // Sort array of String
        List<String> sortedList = Arrays.stream(str).sorted().toList();

        // find common prefix between first and last
        String first = sortedList.get(0);
        String last = sortedList.get(sortedList.size() - 1);

        int start = 0;

        while (start < first.length() && start < last.length() && first.charAt(start) == last.charAt(start)) {
            start++;
        }

        return first.substring(0, start);
    }
}
