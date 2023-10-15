package programmers.practice.lv2;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ProceedHomework_176962 {
    public String[] solution(String[][] plans) {
        List<String> answerList = new ArrayList<>();
        Homework[] homework = new Homework[plans.length];
        for (int i = 0; i < homework.length; i++) {
            homework[i] = new Homework(plans[i]);
        }
        Arrays.sort(homework, Comparator.comparing(Homework::getStartTime));
        Queue<Homework> remainHomework = new LinkedList<>(Arrays.asList(homework));
        Stack<Homework> homeworkStack = new Stack<>();
        homeworkStack.add(remainHomework.poll());
        while (!remainHomework.isEmpty()) {
            long remainTime = ChronoUnit.MINUTES.between(homeworkStack.peek().getStartTime(), remainHomework.peek().getStartTime());
            while (remainTime > 0 && !homeworkStack.isEmpty()) {
                remainTime = homeworkStack.peek().doHomework(remainTime);
                if (homeworkStack.peek().isFinished()) {
                    answerList.add(homeworkStack.pop().getName());
                }
            }
            homeworkStack.add(remainHomework.poll());
        }

        while (!homeworkStack.isEmpty()) {
            answerList.add(homeworkStack.pop().getName());
        }

        return answerList.toArray(new String[0]);
    }

    public class Homework {
        String name;
        LocalDateTime startTime;
        long remain;

        public Homework(String[] plan) {
            String[] date = plan[1].split(":");
            this.name = plan[0];
            this.startTime = LocalDateTime.of(1993, 2, 19, Integer.parseInt(date[0]), Integer.parseInt(date[1]));
            this.remain = Long.parseLong(plan[2]);
        }

        public long doHomework(long time) {
            if (remain <= time) {
                time -= this.remain;
                this.remain = 0;
                return time;
            } else {
                this.remain -= time;
                return 0;
            }
        }

        public boolean isFinished() {
            return remain == 0;
        }

        public String getName() {
            return name;
        }

        public LocalDateTime getStartTime() {
            return startTime;
        }
    }
}
