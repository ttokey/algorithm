package programmers.practice.lv2;

import java.util.ArrayList;
import java.util.List;

public class NQueen_12952 {
    int count = 0;

    public int solution(int n) {
        findQueen(0, new ArrayList<Queen>(), n);
        return count;
    }

    public void findQueen(int row, List<Queen> queenList, int n) {
        if (row >= n) {
            count++;
        }

        for (int i = 0; i < n; i++) {
            Queen newQueen = new Queen(row, i);
            if (!newQueen.isCanAttack(queenList)) {
                queenList.add(newQueen);
                findQueen(row + 1, queenList, n);
                queenList.remove(queenList.size() - 1);
            }
        }
    }

    public class Queen {
        int row;
        int col;

        public Queen(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public boolean isCanAttack(List<Queen> others) {
            for (Queen other : others) {
                if (this.row == other.row
                        || this.col == other.col
                        || Math.abs(((double) this.col - other.col) / (this.row - other.row)) == 1.0) {
                    return true;
                }
            }
            return false;
        }
    }
}
