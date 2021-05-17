package inflearn.string;
/*
설명
한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
문자열의 길이는 100을 넘지 않는다.

출력
첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LowerDistanceChar {


    public static String solution(String input) {
        String[] inputList = input.split(" ");
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < inputList[0].length(); i++) {
            output.add(Integer.MAX_VALUE);
        }
        int index = inputList[0].indexOf(inputList[1], 0);
        output = findLowerDistance(output, index);
        while (index != -1) {
            output = findLowerDistance(output, index);
            index = inputList[0].indexOf(inputList[1], index + 1);
        }
        return printOutput(output);
    }

    public static String printOutput(List<Integer> output) {
        StringBuilder sb = new StringBuilder();
        output.stream()
                .forEach(v -> sb.append(v).append(" "));
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static List<Integer> findLowerDistance(List<Integer> input, int index) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            if (Math.abs(index - i) < input.get(i)) {
                output.add(Math.abs(index - i));
            } else {
                output.add(input.get(i));
            }
        }
        return output;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(solution(input));
    }
}
