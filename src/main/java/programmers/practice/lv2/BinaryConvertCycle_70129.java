package programmers.practice.lv2;

public class BinaryConvertCycle_70129 {
    public int[] solution(String s) {
        int zeroCount = 0;
        int convertCount = 0;
        while (!s.equals("1")) {
            char[] binaryChar = s.toCharArray();
            int oneCount = 0;
            for (char c : binaryChar) {
                if (c == '1') {
                    oneCount++;
                }
            }
            zeroCount += binaryChar.length - oneCount;
            s = Integer.toBinaryString(oneCount);
            convertCount++;
        }
        int[] result = {convertCount, zeroCount};
        return result;
    }
}
