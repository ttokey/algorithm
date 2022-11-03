package programmers.practice;

public class Pibonacci {
    public int solution(int n) {
        int answer = cal(0, 1, 2, n);
        return answer;
    }

    public int cal(int n1, int n2, int count, int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (n == count) {
            return (n1 + n2) % 1234567;
        }

        return cal(n2 % 1234567, (n1 + n2) % 1234567, count + 1, n);
    }
}


//    public int solution(int n) {
//        int answer = cal(0, 1, 2, n);
//        return answer;
//    }
//
//    public int cal(int n1, int n2, int count, int n) {
//        if (n == 0 || n == 1) {
//            return n;
//        }
//
//        if (n == count) {
//            return (n1 + n2) % 1234567;
//        }
//
//        return cal(n2 % 1234567, (n1 + n2) % 1234567, count + 1, n);
//    }