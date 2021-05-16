package inflearn.string;

import java.util.Scanner;

public class TransAlphabet {
    public static String solution(String input) {
        int start = findNextAlphabet(input, -1);
        int end = findPreviousAlphabet(input, input.length());

        while (start < end) {
            input = change(input, start, end);
            start = findNextAlphabet(input, start);
            end = findPreviousAlphabet(input, end);
        }
        return input;
    }

    public static int findNextAlphabet(String input, int start) {
        int next = start;
        for (int i = start + 1; i < input.length(); i++) {
            if (Character.isAlphabetic(input.charAt(i))) {
                next = i;
                break;
            }
        }
        return next;
    }

    public static int findPreviousAlphabet(String input, int end) {
        int previous = end;
        for (int i = end - 1; i >= 0; i--) {
            if (Character.isAlphabetic(input.charAt(i))) {
                previous = i;
                break;
            }
        }
        return previous;
    }

    public static String change(String input, int start, int end) {
        char[] listString = input.toCharArray();
        char temp = listString[start];
        listString[start] = listString[end];
        listString[end] = temp;
        return String.copyValueOf(listString);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(solution(input));
    }
}
