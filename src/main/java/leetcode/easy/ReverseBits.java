package leetcode.easy;

public class ReverseBits {
    public static int reverseBits(int n) {

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += n & 1;
            n = n >> 1;
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(reverseBits(1));
        System.out.println(0 << 1);

    }
}
