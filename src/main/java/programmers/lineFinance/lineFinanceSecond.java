package programmers.lineFinance;

public class lineFinanceSecond {
    int count = 0;

    public int solution(int[] arr) {

        next(arr, 0, arr.length - 1);
        return count;
    }

    public void next(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        if (arr[start] < arr[start + 1]) {
            if (isA(arr, start + 1, end)) {
                count++;
                next(arr, start + 1, end);
            }
        }
        if (arr[end] < arr[end - 1]) {
            if (isA(arr, start, end - 1)) {
                count++;
                next(arr, start, end - 1);
            }
        }
    }

    public boolean isA(int[] arr, int start, int end) {
        return true;
    }
}
