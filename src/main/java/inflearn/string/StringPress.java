package inflearn.string;
/*
11. 문자열 압축
설명
알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
단 반복횟수가 1인 경우 생략합니다.

입력
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

출력
 */


import java.util.Scanner;

public class StringPress {

    public static String solution(String input) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < input.length()) {
            char indexChar = input.charAt(i);
            int sameNumber = findSame(input, i);
            sb.append(indexChar);
            if (sameNumber > 1) {
                sb.append(sameNumber);
            }
            i += sameNumber;
        }
        return sb.toString();
    }

    public static int findSame(String input, int i) {
        int result = 1;
        while (isNextSame(input, i)) {
            result++;
            i++;
        }
        return result;
    }

    public static boolean isNextSame(String input, int i) {
        if (i >= input.length() - 1) {
            return false;
        }
        char indexChar = input.charAt(i);
        char nextChar = input.charAt(i + 1);
        if (indexChar == nextChar) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(solution(input));
    }
}
