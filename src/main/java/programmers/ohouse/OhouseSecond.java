package programmers.ohouse;

import java.util.ArrayList;
import java.util.List;

public class OhouseSecond {
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
                dfs((count + 1) % 3, index + 1, ohoCount + 1);
            } else {
                dfs((count + 1) % 3, index + 1, ohoCount);
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
        return press(result);
    }

    public List<Integer> canH(int index) {
        List<Integer> result = new ArrayList<>();
        for (int i = index; i < visited.length; i++) {
            if (!visited[i] && charArray[i] == 'h') {
                result.add(i);
            }
        }
        return press(result);
    }

    public List<Integer> press(List<Integer> input) {
        List<Integer> output = new ArrayList<>();

        int index = 0;
        while (index < input.size()) {
            int startIndex = index;
            int start = input.get(index);
            index++;
            while (index < input.size()) {
                if (input.get(index) - start == 1) {
                    start = input.get(index);
                    index++;
                } else {
                    break;
                }
            }
            output.add(input.get(startIndex));
        }
        return output;
    }


}
