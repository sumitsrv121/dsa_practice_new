package basic_string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortFrequencies {
    public static void main(String[] args) {
        SortFrequencies sortFrequencies = new SortFrequencies();
        System.out.println(sortFrequencies.frequencySort("tree"));
        System.out.println(sortFrequencies.frequencySort("raaaajj"));
        System.out.println(sortFrequencies.frequencySort("bbccddaaa"));
    }

    public List<Character> frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.merge(ch, 1, Integer::sum);
        }

        LinkedHashMap<Character, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    if (o1.getValue() > o2.getValue()) {
                        return -1;
                    } else if (o1.getValue() < o2.getValue()) {
                        return 1;
                    } else {
                        return Character.compare(o1.getKey(), o2.getKey());
                    }
                }).collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new)
                );

        return sortedMap.keySet().stream().toList();
    }
}
