package basic_recursion;

import java.util.Vector;

public class ReverseString {
    public static void main(String[] args) {
        Vector<Character> v = new Vector<>();
        v.add('h');
        v.add('e');
        v.add('l');
        v.add('l');
        v.add('o');
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverseString(v));
    }

    public Vector<Character> reverseString(Vector<Character> s) {
        return reverseCharArray(s, 0, s.size() - 1);
    }

    private Vector<Character> reverseCharArray(Vector<Character> s, int start, int end) {
        if (start >= end) {
            return s;
        }
        char temp = s.get(start);
        s.set(start, s.get(end));
        s.set(end, temp);

        return reverseCharArray(s, start + 1, end - 1);
    }
}
