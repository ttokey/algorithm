package programmers.kakao;

public class Second {

    public int solution(int n, int k) {
        String stringN = makeNum(n, k);
        int answer = getResult(stringN);
        return answer;
    }

    public int getResult(String input) {
        int count = 0;
        String[] split = input.split("0+");
        for (String s : split) {
            s = s.replace(" ", "");
            if (isPrime(Integer.parseInt(s))) {
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public String makeNum(int n, int k) {
        String result = "";
        while (n > 0) {
            result = (n % k) + result;
            n /= k;
        }
        return result;
    }
}
