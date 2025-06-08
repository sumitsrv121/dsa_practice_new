package basic_string;

public class LargestOddNumber {
    public static void main(String[] args) {
        LargestOddNumber largestOddNumber = new LargestOddNumber();
        System.out.println(largestOddNumber.largeOddNum("5347"));
        System.out.println(largestOddNumber.largeOddNum("0214638"));
        System.out.println(largestOddNumber.largeOddNum("0032579"));
    }

    public String largeOddNum(String s) {
        // find first odd number from end
        int endIndex = s.length() - 1;

        while (endIndex >= 0) {
            int val = s.charAt(endIndex) - '0';
            if (val % 2 != 0) {
                break;
            }
            endIndex--;
        }

        // start end first non-zero number
        int startIndex = 0;
        while (startIndex < s.length()) {
            int val = s.charAt(startIndex) - '0';
            if (val != 0) {
                break;
            }
            startIndex++;
        }

        if (startIndex > endIndex) {
            return "";
        }
        return s.substring(startIndex, endIndex + 1);
    }
}
