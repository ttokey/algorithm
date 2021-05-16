package inflearn.string;

import java.util.Scanner;

public class PalindromeString {

    public static String solution(String input) {
        int start = 0;
        int end = input.length() - 1;
        input = input.toLowerCase();
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return "NO";
            }
            start++;
            end--;
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(solution(input));
    }
}
