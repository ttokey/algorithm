package programmers.practice.lv2;

public class BowContest_92342 {
    int maxScore = Integer.MIN_VALUE;
    int[] resultLion = new int[11];
    int[] peach = new int[11];


    public int[] solution(int n, int[] info) {
        peach = info;
        bow(0, n, new int[11]);
        for (int i = 0; i < resultLion.length; i++) {
            if (resultLion[i] != 0) {
                return resultLion;
            }
        }
        return new int[]{-1};
    }

    public void bow(int index, int remainderN, int[] lion) {

        int scoreDiff = nowScoreDiff(lion);
        if (remainderN == 0 && scoreDiff > 0) {
            if (scoreDiff > maxScore) {
                maxScore = scoreDiff;
                resultLion = lion.clone();
            } else if (scoreDiff == maxScore) {
                updateLion(lion);
            }
            return;
        }

        if (index >= lion.length) {
            int[] temp = lion.clone();
            temp[10] = remainderN;
            scoreDiff = nowScoreDiff(temp);
            if (scoreDiff > 0) {
                if (scoreDiff > maxScore) {
                    maxScore = scoreDiff;
                    resultLion = temp.clone();
                } else if (scoreDiff == maxScore) {
                    updateLion(lion);
                }
            }
            return;
        }

        int[] copyLion = lion.clone();
        bow(index + 1, remainderN, copyLion);
        if (peach[index] + 1 <= remainderN) {
            copyLion[index] = peach[index] + 1;
            bow(index + 1, remainderN - peach[index] - 1, copyLion);
        }
    }

    public int nowScoreDiff(int[] lion) {
        int result = 0;
        for (int i = 0; i < lion.length; i++) {
            if (peach[i] != 0 || lion[i] != 0) {
                if (peach[i] < lion[i]) {
                    result = result + 10 - i;
                } else {
                    result = result - 10 + i;
                }
            }
        }
        return result;
    }

    public void updateLion(int[] input) {
        for (int i = 10; i >= 0; i--) {
            if ((input[i] != 0 || resultLion[i] != 0)) {
                if (input[i] > resultLion[i]) {
                    resultLion = input.clone();
                }
                return;
            }
        }
    }
}
