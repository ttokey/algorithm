package programmers.lineFinance;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//입출력 예
//        record	result
//        ["P 300 6", "P 500 3", "S 1000 4", "P 600 2", "S 1200 1"]	[1500, 2400]
//        ["P 300 6", "P 500 3", "S 1000 4", "P 600 1", "S 1200 2"]	[1800, 2700]
//        ["P 100 4", "P 300 9", "S 1000 7", "P 1000 8", "S 700 7", "S 700 3"]	[7100, 10700]
public class lineFinanceFirst {
    public int[] solution(String[] record) {

        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();

        int qResult = 0;
        int sResult = 0;
        for (String input : record) {
            String[] split = input.split(" ");
            if ("P".equals(split[0])) {
                for (int i = 0; i < Integer.parseInt(split[2]); i++) {
                    q.add(Integer.parseInt(split[1]));
                    s.add(Integer.parseInt(split[1]));
                }
            } else {
                for (int i = 0; i < Integer.parseInt(split[2]); i++) {
                    qResult += q.poll();
                    sResult += s.pop();
                }
            }
        }
        int[] answer = {qResult, sResult};
        return answer;
    }
}
