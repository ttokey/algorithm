package programmers.practice.lv1;

public class CeaserCipher_12926 {
    public String solution(String s, int n) {
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            charArr[i] = encrypt(charArr[i], n);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(charArr);
        return sb.toString();
    }

    public char encrypt(char input, int n) {
        if (input >= 'a' && input <= 'z') {
            input += n;
            if (input > 'z') {
                input -= 'z' - 'a' + 1;
            }
        } else if (input >= 'A' && input <= 'Z') {
            input += n;
            if (input > 'Z') {
                input -= 'Z' - 'A' + 1;
            }
        }
        return input;
    }
}
