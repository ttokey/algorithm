package programmers.practice.lv1;

import java.util.ArrayList;
import java.util.List;

public class DartGame_17682 {
    public int solution(String dartResult) {
        int totalScore = 0;
        String[] dartResultSplit = dartResult.replaceAll("(([0-9]|[10])[S|D|T][*|#]?)", "$1 ").split(" ");
        List<Dart> dartList = new ArrayList<>();
        for (String dartScore : dartResultSplit) {
            Dart dart = new Dart(dartScore);
            dartList.add(dart);
        }

        boolean isDouble = false;
        for (int i = dartList.size() - 1; i >= 0; i--) {
            Dart dart = dartList.get(i);
            totalScore += dart.getScore(isDouble);
            if (dart.isDouble()) {
                isDouble = true;
            } else {
                isDouble = false;
            }
        }
        return totalScore;
    }

    public class Dart {
        int score;
        int SDT;
        String option;

        public Dart(String input) {
            String[] split = input.replaceAll("([0-9]|[10])([S|D|T])([*|#]?)", "$1 $2 $3").split(" ");
            score = Integer.parseInt(split[0]);
            if (split[1].equals("S")) {
                SDT = 1;
            } else if (split[1].equals("D")) {
                SDT = 2;
            } else {
                SDT = 3;
            }
            option = "";
            if (split.length > 2) {
                option = split[2];
            }
        }

        public boolean isDouble() {
            return this.option.equals("*") ? true : false;
        }

        public int getScore(boolean isDouble) {
            int resultScore = (int) Math.pow(score, SDT);
            if (option.equals("*")) {
                resultScore *= 2;
            } else if (option.equals("#")) {
                resultScore = -resultScore;
            }
            return isDouble ? resultScore * 2 : resultScore;
        }
    }
}
