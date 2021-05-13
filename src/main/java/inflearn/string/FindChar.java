package inflearn.string;

import java.util.Scanner;

public class FindChar {
    public static int solution(String a, char b) {
        int result = 0;
        a = a.toUpperCase();
        b = Character.toUpperCase(b);
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        char input2 = in.next().charAt(0);
        System.out.println(solution(input1, input2));
        return;
    }
}
