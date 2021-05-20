package inflearn.Array;
/*
설명
N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
(첫 번째 수는 무조건 출력한다)

입력
첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.

출력
자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.

예시 입력 1
6
7 3 9 5 6 12

예시 출력 1
7 9 6 12
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BigNumber {
    public static String solution(List<Integer> inputList) {
        StringBuilder sb = new StringBuilder();
        sb.append(inputList.get(0));
        int previousNumber = inputList.get(0);
        for (int i = 1; i < inputList.size(); i++) {
            if (previousNumber < inputList.get(i)) {
                sb.append(" ").append(inputList.get(i));
            }
            previousNumber = inputList.get(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input1 = scanner.nextInt();
        List<Integer> inputList = new ArrayList<>();
        IntStream.range(0, input1)
                .forEach(i -> inputList.add(scanner.nextInt()));
        System.out.println(solution(inputList));
    }
}
