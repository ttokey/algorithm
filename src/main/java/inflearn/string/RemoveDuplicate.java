package inflearn.string;

import java.util.Scanner;

public class RemoveDuplicate {
    public static String solution(String input) {
        StringBuilder sb = new StringBuilder();
        while (input.length() > 0) {
            char temp = input.charAt(0);
            sb.append(temp);
            input = input.replaceAll(String.valueOf(temp), "");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(solution(input));
    }
}
