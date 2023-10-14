package programmers.practice.lv2;

public class ContinuousSum_178870 {
    public int[] solution(int[] sequence, int k) {
        int sum = 0;
        int minSize = Integer.MAX_VALUE;
        int start = 0;
        int[] answer = new int[]{0, 0};

        for (int i = 0; i < sequence.length; i++) {
            sum += sequence[i];
            while (sum > k) {
                sum -= sequence[start];
                start++;
            }
            if (sum == k) {
                if (minSize > (i - start)) {
                    minSize = i - start;
                    answer[0] = start;
                    answer[1] = i;
                }
            }
        }
        return answer;
    }
}
