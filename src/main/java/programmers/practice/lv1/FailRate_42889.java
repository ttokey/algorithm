package programmers.practice.lv1;

import java.util.ArrayList;
import java.util.List;

public class FailRate_42889 {
    public int[] solution(int N, int[] stages) {
        List<Stage> stageList = new ArrayList<>();
        int playerCount = stages.length;
        for (int i = 0; i <= N; i++) {
            stageList.add(new Stage(i));
        }
        for (int stage : stages) {
            stageList.get(stage - 1).plusClearCount();
        }
        for (int i = 0; i <= N; i++) {
            Stage stage = stageList.get(i);
            stage.calClearRate(playerCount);
            playerCount -= stage.getClearCount();
        }
        stageList.remove(N);
        return stageList.stream()
                .sorted((a, b) -> a.compare(b))
                .mapToInt(s -> s.getIndex())
                .toArray();
    }

    public class Stage {
        int index;
        double clearRate = 0.0;
        int clearCount = 0;

        public Stage(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index + 1;
        }

        public int getClearCount() {
            return this.clearCount;
        }

        public void plusClearCount() {
            this.clearCount++;
        }

        public void calClearRate(int playerCount) {
            if (playerCount != 0) {
                this.clearRate = (double) clearCount / playerCount;
            }
        }

        public int compare(Stage stage) {
            double result = stage.clearRate - this.clearRate;
            if (result < 0) {
                return -1;
            } else if (result == 0) {
                return 0;
            }
            return 1;
        }
    }
}
