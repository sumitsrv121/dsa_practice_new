package basic_hashing.contest;

import java.util.*;

public class GroupWordsByAnagram {
    public static void main(String[] args) {
        GroupWordsByAnagram groupWordsByAnagram = new GroupWordsByAnagram();

        System.out.println(groupWordsByAnagram.groupAnagrams(new String[]{"race", "care", "acre", "bake", "beak", "keep"}));
        System.out.println(groupWordsByAnagram.groupAnagrams(new String[]{"bob", "obb", "boo", "oob", "bbo"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroup = new HashMap<>();
        for (String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);

            String newStr = new String(arr);

            List<String> list;
            if (anagramGroup.containsKey(newStr)) {
                list = anagramGroup.get(newStr);
            } else {
                list = new ArrayList<>();
            }
            list.add(str);
            anagramGroup.put(newStr, list);
        }
        return new ArrayList<>(anagramGroup.values());
    }
}
