package programmers.practice.lv2;

import java.math.BigInteger;

public class FineRectangle_62048 {
    public long solution(int w, int h) {
        BigInteger b1 = BigInteger.valueOf(w);
        BigInteger b2 = BigInteger.valueOf(h);
        BigInteger gcd = b1.gcd(b2);
        return (long) w * h - (w + h - gcd.intValue());
    }
}
