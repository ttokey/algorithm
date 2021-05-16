package inflearn.string;

import java.util.Scanner;

public class ValidPalindrome {

    public static String solution(String input) {
        input = input.toLowerCase();
        input = removeNotAlphabet(input);
        if (input == reverseString(input)) {
            return "YES";
        }
        return "NO";
    }

    public static String removeNotAlphabet(String input) {
        return input.replaceAll("^[a-zA-z]", "");
    }

    public static String reverseString(String input) {
        StringBuffer sb = new StringBuffer();
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(solution(input));
    }
}
