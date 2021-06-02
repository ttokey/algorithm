package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeciBinaryNumbers {

    public static int solution(String input) {
        char[] inputs = input.toCharArray();
        List<Integer> inputNumber = new ArrayList<>();
        for (char c : inputs) {
            inputNumber.add(Integer.parseInt(String.valueOf(c)));
        }
        return inputNumber.stream()
                .mapToInt(x -> x)
                .max()
                .getAsInt();

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(solution(input));
    }
}
