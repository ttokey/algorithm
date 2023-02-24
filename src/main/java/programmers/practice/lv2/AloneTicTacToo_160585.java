package programmers.practice.lv2;

import java.util.HashSet;
import java.util.Set;

public class AloneTicTacToo_160585 {
    public int solution(String[] board) {
        String[][] boardMap = new String[3][3];
        for (int i = 0; i < 3; i++) {
            boardMap[i] = board[i].split("");
        }
        return firstLast(boardMap, 0) && isFinish(boardMap) ? 1 : 0;
    }

    public boolean firstLast(String[][] boardMap, int type) {
        int OCount = 0;
        int XCount = 0;
        for (String[] x : boardMap) {
            for (String y : x) {
                if ("O".equals(y)) {
                    OCount++;
                } else if ("X".equals(y)) {
                    XCount++;
                }
            }
        }
        if (type == 0) {
            return OCount == XCount || OCount == XCount + 1;
        } else if (type == 1) {
            //O가 이겼을 때
            return OCount == XCount + 1;
        }
        //X가 이겼을 때
        return OCount == XCount;
    }

    public boolean isFinish(String[][] boardMap) {
        Set<String> temp = new HashSet<>();
        String str = "";
        for (int i = 0; i < 3 && temp.size() <= 1; i++) {
            str = String.join("", boardMap[i]);
            if (isXO(str)) {
                temp.add(str);
            }
            str = boardMap[0][i] + boardMap[1][i] + boardMap[2][i];
            if (isXO(str)) {
                temp.add(str);
            }
        }
        str = boardMap[0][0] + boardMap[1][1] + boardMap[2][2];
        if (isXO(str)) {
            temp.add(str);
        }
        str = boardMap[2][0] + boardMap[1][1] + boardMap[0][2];
        if (isXO(str)) {
            temp.add(str);
        }
        if (temp.size() > 1) {
            return false;
        }
        if (temp.size() == 1) {
            return temp.toArray()[0].equals("OOO") ? firstLast(boardMap, 1) : firstLast(boardMap, 2);
        }
        return true;
    }

    public boolean isXO(String input) {
        return input.equals("XXX") || input.equals("OOO");
    }
}
