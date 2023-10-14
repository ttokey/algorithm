package programmers.practice.lv2;

public class BetweenTwoCircle_181187 {
    public long solution(int r1, int r2) {
        long answer = 0;
        for (int x = 0; x <= r2; x++) {
            long maxY = (long) Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2)));
            long minY = (long) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2)));
            answer += maxY - minY + 1;
        }
        return answer * 4 - (r2 - r1 + 1) * 4;
    }
}
