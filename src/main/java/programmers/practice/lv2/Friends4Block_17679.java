package programmers.practice.lv2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Friends4Block_17679 {
    public int solution(int m, int n, String[] boards) {
        int answer = 0;
        List<LinkedList<String>> boardList = new ArrayList<>();
        for (int j = 0; j < boards[0].length(); j++) {
            LinkedList<String> input = new LinkedList<>();
            for (int i = boards.length - 1; i >= 0; i--) {
                input.add(boards[i].substring(j, j + 1));
            }
            boardList.add(input);
        }
        boolean isPang = true;
        while (isPang) {
            isPang = false;
            Map<Integer, Set<Integer>> pangMap = new HashMap<>();
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (isTwoByTwo(boardList, i, j)) {
                        isPang = true;
                        for (int k = i; k >= i - 1; k--) {
                            Set<Integer> inputValue = pangMap.getOrDefault(k, new HashSet<Integer>());
                            inputValue.add(j);
                            inputValue.add(j - 1);
                            pangMap.put(k, inputValue);
                        }
                    }
                }
            }
            for (int i : pangMap.keySet()) {
                for (int index : pangMap.get(i).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())) {
                    boardList.get(i).remove(index);
                    answer++;
                }
            }
        }
        return answer;
    }

    public boolean isTwoByTwo(List<LinkedList<String>> boardList, int i, int j) {
        Set<String> boardSet = new HashSet<>();
        if (i < boardList.size() && j < boardList.get(i).size() && j < boardList.get(i - 1).size()) {
            boardSet.add(boardList.get(i).get(j));
            boardSet.add(boardList.get(i).get(j - 1));
            boardSet.add(boardList.get(i - 1).get(j));
            boardSet.add(boardList.get(i - 1).get(j - 1));
            if (boardSet.size() == 1) {
                return true;
            }
        }
        return false;
    }
}
