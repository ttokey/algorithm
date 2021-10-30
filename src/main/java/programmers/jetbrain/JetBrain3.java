package programmers.jetbrain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JetBrain3 {
    List<Long> rowMove = new ArrayList<>();
    List<Long> columnMove = new ArrayList<>();


    public long solution(int n, int m, int x, int y, int[][] queries) {
        for (int[] query : queries) {
            if (query[0] == 0) {
                columnMove.add(-Long.valueOf(query[1]));
            }
            if (query[0] == 1) {
                columnMove.add(Long.valueOf(query[1]));
            }
            if (query[0] == 2) {
                rowMove.add(-Long.valueOf(query[1]));
            }
            if (query[0] == 3) {
                rowMove.add(Long.valueOf(query[1]));
            }
        }

        Set<Long> columnSet = new HashSet<>();
        columnSet.add((long) y);
        for (int i = columnMove.size() - 1; i >= 0; i--) {
            Set<Long> temp = new HashSet<>();
            for (Long nowY : columnSet) {
                if (columnMove.get(i) < 0 && nowY == 0) {
                    for (long j = 0; j <= -columnMove.get(i); j++) {
                        temp.add(Math.min(n - 1, j));
                    }
                } else if (columnMove.get(i) > 0 && nowY == n - 1) {
                    for (long j = m - 1; j >= m - 1 - columnMove.get(i); j--) {
                        temp.add(j);
                    }
                } else if (nowY - columnMove.get(i) >= 0 && nowY - columnMove.get(i) < m - 1) {
                    temp.add(nowY - columnMove.get(i));
                } else if (nowY - columnMove.get(i) < 0) {
                    temp.add((long) 0);
                } else if (nowY - columnMove.get(i) >= n - 1) {
                    temp.add((long) n - 1);
                }
            }
            if (temp.size() == 0) {
                return 0;
            }
            columnSet = temp;
        }


        Set<Long> rowSet = new HashSet<>();
        rowSet.add((long) x);
        for (int i = rowMove.size() - 1; i >= 0; i--) {
            Set<Long> temp = new HashSet<>();
            for (Long nowX : rowSet) {
                if (rowMove.get(i) < 0 && nowX == 0) {
                    for (long j = 0; j <= -rowMove.get(i); j++) {
                        temp.add(Math.min(m - 1, j));
                    }
                } else if (rowMove.get(i) > 0 && nowX == n - 1) {
                    for (long j = n - 1; j >= n - 1 - rowMove.get(i); j--) {
                        temp.add(j);
                    }
                } else if (nowX - rowMove.get(i) >= 0 && nowX - rowMove.get(i) < n - 1) {
                    temp.add(nowX - rowMove.get(i));
                } else if (nowX - rowMove.get(i) < 0) {
                    temp.add((long) 0);
                } else if (nowX - rowMove.get(i) >= n - 1) {
                    temp.add((long) n - 1);
                }

            }
            if (temp.size() == 0) {
                return 0;
            }
            rowSet = temp;
        }


        return columnSet.size() * rowSet.size();

    }
}
