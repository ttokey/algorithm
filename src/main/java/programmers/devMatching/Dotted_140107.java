package programmers.devMatching;

public class Dotted_140107 {
    public long solution(int k, int d) {
        long answer = 0;
        for (long i = 0; (i * k) <= d; i++) {
            long maxX = getMaxX(i * k, d);
            answer += Math.floor(maxX / k) + 1;
        }
        return answer;
    }

    public long getMaxX(long y, long d) {
        return (long) Math.floor(Math.sqrt((double) Math.pow(d, 2) - Math.pow(y, 2)));
    }
}
