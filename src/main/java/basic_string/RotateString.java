package basic_string;

public class RotateString {
    public static void main(String[] args) {
        RotateString rotateString = new RotateString();
        System.out.println(rotateString.rotateString("abcde", "cdeab"));
        System.out.println(rotateString.rotateString("abcde", "adeac"));
        System.out.println(rotateString.rotateString("abcde", "abcde"));
    }

    public boolean rotateString(String source, String goal) {
        if (source.length() != goal.length()) {
            return false;
        }

        String doubleStr = source + source;
        return doubleStr.contains(goal);
    }
}
