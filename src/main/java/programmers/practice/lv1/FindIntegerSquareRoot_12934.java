package programmers.practice.lv1;

public class FindIntegerSquareRoot_12934 {
    public long solution(long n) {
        return n % Math.sqrt(n) == 0 ? (long) Math.pow(Math.sqrt(n) + 1, 2) : -1;
    }
}
