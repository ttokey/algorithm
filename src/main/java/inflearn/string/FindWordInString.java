package inflearn.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindWordInString {

    public static String solution(String input) {
        List<String> splitString = new ArrayList<>();
        splitString = Arrays.stream(input.split(" "))
                .collect(Collectors.toList());

        int length = Integer.MIN_VALUE;
        String output = "";
        for (String split : splitString) {
            if (split.length() > length) {
                length = split.length();
                output = split;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(solution(input));
        return;
    }
}
