package basic_string;

import java.util.Vector;

public class ReverseString {
    public static void main(String[] args) {
        Vector<Character> vector = new Vector<>();
        vector.add('h');
        vector.add('e');
        vector.add('l');
        vector.add('l');
        vector.add('o');
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(vector);
        System.out.println(vector);
    }

    public void reverseString(Vector<Character> s) {
        int start = 0;
        int end = s.size() - 1;

        while (start < end) {
            char temp = s.get(start);
            s.set(start, s.get(end));
            s.set(end, temp);
            start++;
            end--;
        }
    }
}
