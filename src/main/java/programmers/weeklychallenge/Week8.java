package programmers.weeklychallenge;

public class Week8 {
    class Solution {
        public int solution(int[][] sizes) {
            int firstMax = 0;
            int secondMax = 0;

            for (int[] size : sizes) {
                if (size[0] > size[1]) {
                    firstMax = Math.max(firstMax, size[0]);
                    secondMax = Math.max(secondMax, size[1]);
                } else {
                    firstMax = Math.max(firstMax, size[1]);
                    secondMax = Math.max(secondMax, size[0]);
                }
            }

            int answer = firstMax * secondMax;
            return answer;
        }
    }
}
