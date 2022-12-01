package programmers.practice.lv2;

public class Tired_87946 {
    int maxCount = 0;
    boolean[] visitDungeons;

    public int solution(int k, int[][] dungeons) {
        visitDungeons = new boolean[dungeons.length];
        doDungeons(0, dungeons, k, 0);
        return maxCount;
    }

    public void doDungeons(int index, int[][] dungeons, int tired, int count) {
        maxCount = Math.max(maxCount, count);
        for (int i = 0; i < dungeons.length; i++) {
            if (visitDungeons[i] == false && dungeons[i][0] <= tired) {
                visitDungeons[i] = true;
                doDungeons(i, dungeons, tired - dungeons[i][1], count + 1);
                visitDungeons[i] = false;
            }
        }
    }
}
