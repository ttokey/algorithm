package programmers.practice.lv2;

public class Pibonacci {

    public int solution(int n) {
        if (n == 0) {
            return 0;
        }
        int result = 0;

        int[] arr = new int[2];
        arr[0] = 0;
        arr[1] = 1;

        boolean flag = true;
        int nextVal = arr[0] + arr[1];
        for (int i = 2; i < n; i++) {
            if (flag) {
                arr[0] = nextVal % 1234567;
            } else {
                arr[1] = nextVal % 1234567;
            }
            nextVal = arr[0] + arr[1];
            flag = !flag;
        }
        result = nextVal;

        return result % 1234567;
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