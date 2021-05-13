package inflearn.string;

import java.util.Scanner;

public class TransChar {

    public static String solution(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLowerCase(input.charAt(i))) {
                sb.append(Character.toUpperCase(input.charAt(i)));
            } else {
                sb.append(Character.toLowerCase(input.charAt(i)));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toString();
        System.out.println(solution(input));
        return;
    }

}
