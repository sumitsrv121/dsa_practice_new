package basic_string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isomorphicString("egg", "add"));
        System.out.println(isomorphicStrings.isomorphicString("apple", "bbnbm"));
        System.out.println(isomorphicStrings.isomorphicString("paper", "title"));
        System.out.println(isomorphicStrings.isomorphicString("ab", "aa"));
    }

    public boolean isomorphicString(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> characterMap = new HashMap<>();
        Map<Character, Character> reverseCharacterMap = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char value = t.charAt(i);

            if (!characterMap.containsKey(key)) {
                characterMap.put(key, value);
            } else {
                if (characterMap.get(key) != value) {
                    return false;
                }
            }

            if (!reverseCharacterMap.containsKey(value)) {
                reverseCharacterMap.put(value, key);
            } else {
                if (reverseCharacterMap.get(value) != key) {
                    return false;
                }
            }
        }
        return true;
    }
}
