package inflearn.string;

import java.util.Scanner;

public class Password {
    public static String solution(int numberOf, String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOf; i++) {
            String passWord = input.substring(0, 7).replace('#', '1').replace('*', '0');
            int decade = Integer.parseInt(passWord, 2);
            sb.append((char) decade);
            input = input.substring(7);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOf = scanner.nextInt();
        String input = scanner.nextLine();
        System.out.println(solution(numberOf, input));
    }
}
