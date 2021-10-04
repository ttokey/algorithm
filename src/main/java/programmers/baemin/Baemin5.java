package programmers.baemin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baemin5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        input.toUpperCase();

        System.out.println(input);
    }
}
