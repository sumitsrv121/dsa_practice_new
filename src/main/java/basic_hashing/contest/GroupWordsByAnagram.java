package basic_hashing.contest;

import java.util.*;

public class GroupWordsByAnagram {
    public static void main(String[] args) {
        GroupWordsByAnagram groupWordsByAnagram = new GroupWordsByAnagram();

        System.out.println(groupWordsByAnagram.groupAnagrams(new String[]{"race", "care", "acre", "bake", "beak", "keep"}));
        System.out.println(groupWordsByAnagram.groupAnagrams(new String[]{"bob", "obb", "boo", "oob", "bbo"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> characterMapToStr = new HashMap<>();

        for (String str : strs) {

            int[] countArr = new int[26];
            for (char c: str.toCharArray()) {
                countArr[c - 'a'] += 1;
            }

            StringBuilder builder = new StringBuilder();
            for (int count: countArr) {
                builder.append(count);
                builder.append("#");
            }
            String countStr = builder.toString();

            characterMapToStr.computeIfAbsent(countStr, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(characterMapToStr.values());
    }

    private static ArrayList<List<String>> bruteForce(String[] strs) {
        Map<String, List<String>> anagramGroup = new HashMap<>();
        for (String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);

            String newStr = new String(arr);

            anagramGroup.computeIfAbsent(newStr, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(anagramGroup.values());
    }
}
