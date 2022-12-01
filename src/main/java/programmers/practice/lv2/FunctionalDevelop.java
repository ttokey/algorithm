package programmers.practice.lv2;


//https://programmers.co.kr/learn/courses/30/lessons/42586

//입출력 예
//        progresses	speeds	return
//        [93, 30, 55]	[1, 30, 5]	[2, 1]
//        [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class FunctionalDevelop {
    public final int finishProgress = 100;

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> reminderDays = getReminderDay(progresses, speeds);
        int[] answer = getAnswer(reminderDays);
        return answer;
    }

    public int[] getAnswer(Queue<Integer> reminderDays) {
        int startDay = reminderDays.poll();
        int count = 1;
        List<Integer> result = new ArrayList<>();

        while (!reminderDays.isEmpty()) {
            if (startDay >= reminderDays.peek()) {
                count++;
                reminderDays.poll();
            } else {
                result.add(count);
                count = 1;
                startDay = reminderDays.poll();
            }
        }
        result.add(count);

        return result.stream().mapToInt(i -> i).toArray();
    }


    public Queue<Integer> getReminderDay(int[] progresses, int[] speeds) {
        Queue<Integer> result = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int reminder = finishProgress - progresses[i];
            if (reminder % speeds[i] > 0) {
                result.add(reminder / speeds[i] + 1);
            } else {
                result.add(reminder / speeds[i]);
            }
        }
        return result;
    }
}
