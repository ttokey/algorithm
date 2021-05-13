package inflearn.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseWord {

    public static List<String> solution(List<String> input) {
        List<String> result = new ArrayList<>();
        input.stream()
                .forEach(s -> result.add(reverse(s)));
        return result;
    }

    public static String reverse(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        List<String> input = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            input.add(scanner.nextLine());
        }
        List<String> output = solution(input);
        output.stream()
                .forEach(s -> System.out.println(s));
    }
}
