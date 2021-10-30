package programmers.ohouse;

import java.util.ArrayList;
import java.util.List;

public class OhouseSecond2 {

    boolean[] visited;
    char[] charArray;
    int maxCount = 0;

    public int solution(String str) {
        visited = new boolean[str.length()];
        charArray = str.toCharArray();
        dfs(0, 0, 0);
        int answer = maxCount;
        return answer;
    }

    public void dfs(int count, int index, int ohoCount) {
        if (count < 2 && index >= visited.length) {
            maxCount = Math.max(maxCount, ohoCount);
            return;
        }
        List<Integer> next = new ArrayList<>();
        if (count == 0) {
            next = canO(0);
            if (next.size() != 0) {
                index = next.get(0);
            }
        } else if (count == 1) {
            next = canH(index);
        } else if (count == 2) {
            next = canO(index);
        }

        if (next.size() == 0) {
            maxCount = Math.max(maxCount, ohoCount);
            return;
        }

        for (int i = 0; i < next.size(); i++) {
            visited[next.get(i)] = true;
            if (count == 2) {
                ohoCount++;
            }
            dfs((count + 1) % 3, index + 1, ohoCount);
            if (count == 2) {
                ohoCount--;
            }
            visited[next.get(i)] = false;
        }
    }

    public List<Integer> canO(int index) {
        List<Integer> result = new ArrayList<>();

        for (int i = index; i < visited.length; i++) {
            if (!visited[i] && charArray[i] == 'o') {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> canH(int index) {
        List<Integer> result = new ArrayList<>();
        for (int i = index; i < visited.length; i++) {
            if (!visited[i] && charArray[i] == 'h') {
                result.add(i);
            }
        }
        return result;
    }

}
