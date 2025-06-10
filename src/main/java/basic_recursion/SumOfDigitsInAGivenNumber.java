package basic_recursion;

public class SumOfDigitsInAGivenNumber {
    public static void main(String[] args) {
        SumOfDigitsInAGivenNumber sum = new SumOfDigitsInAGivenNumber();
        System.out.println(sum.addDigits(529));
    }

    public int addDigits(int num) {
        while(num / 10 != 0) {
            num = findSum(num);
        }
        return num;
    }

    public int findSum(int num) {
        if (num / 10 == 0) {
            return num;
        }

        return num % 10 + findSum(num / 10);
    }
}
