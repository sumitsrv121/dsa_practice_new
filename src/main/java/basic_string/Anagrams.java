package basic_string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Anagrams {
    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();
        System.out.println(anagrams.anagramStrings("anagram", "nagaram"));
        System.out.println(anagrams.anagramStrings("dog", "cat"));
        System.out.println(anagrams.anagramStrings("eat", "tea"));
    }

    public boolean anagramStrings(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sMap.merge(s.charAt(i), 1, Integer::sum);
            tMap.merge(t.charAt(i), 1, Integer::sum);
        }

        if (sMap.size() != tMap.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            if (!tMap.containsKey(entry.getKey()) || !Objects.equals(tMap.get(entry.getKey()), entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}
