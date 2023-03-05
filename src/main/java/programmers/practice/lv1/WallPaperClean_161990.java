package programmers.practice.lv1;

import java.util.ArrayList;
import java.util.List;

public class WallPaperClean_161990 {
    public int[] solution(String[] wallpaper) {
        List<Node> iconList = new ArrayList<>();
        for (int i = 0; i < wallpaper.length; i++) {
            String[] row = wallpaper[i].split("");
            for (int j = 0; j < row.length; j++) {
                if (row[j].equals("#")) {
                    iconList.add(new Node(i, j));
                }
            }
        }
        Node firstNode = iconList.get(0);
        int[] answer = {firstNode.x, firstNode.y, firstNode.x + 1, firstNode.y + 1};

        for (Node icon : iconList) {
            answer[0] = Math.min(answer[0], icon.x);
            answer[1] = Math.min(answer[1], icon.y);
            answer[2] = Math.max(answer[2], icon.x + 1);
            answer[3] = Math.max(answer[3], icon.y + 1);
        }
        return answer;
    }

    public class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
