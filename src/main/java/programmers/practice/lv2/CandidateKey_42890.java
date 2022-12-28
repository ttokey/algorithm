package programmers.practice.lv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CandidateKey_42890 {
    boolean[] used;
    Set<Set<Integer>> relationSet = new HashSet<>();

    public int solution(String[][] relation) {
        used = new boolean[relation[0].length];
        for (int i = 0; i < relation[0].length; i++) {
            used[i] = true;
            dfs(i + 1, relation);
            used[i] = false;
        }
        return relationSet.size();
    }

    private void dfs(int nextCol, String[][] relation) {
        if (isRelation(relation)) {
            addRelationSet(relation);
            return;
        }
        for (int i = nextCol; i < relation[0].length; i++) {
            used[i] = true;
            dfs(i + 1, relation);
            used[i] = false;
        }
    }

    private boolean isRelation(String[][] relation) {
        Set<String> keySet = new HashSet<>();
        for (int i = 0; i < relation.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < used.length; j++) {
                if (used[j]) {
                    sb.append(relation[i][j]);
                }
            }
            keySet.add(sb.toString());
        }
        return keySet.size() == relation.length;
    }

    private void addRelationSet(String[][] relation) {
        Set<Integer> usedSet = new HashSet<>();
        for (int i = 0; i < relation[0].length; i++) {
            if (used[i]) {
                usedSet.add(i);
            }
        }
        boolean isUsed = true;
        List<Set<Integer>> toDelete = new ArrayList<>();
        for (Set<Integer> temp : relationSet) {
            if (temp.containsAll(usedSet)) {
                toDelete.add(temp);
            } else if (usedSet.containsAll(temp)) {
                return;
            }
        }
        for (Set<Integer> temp : toDelete) {
            relationSet.remove(temp);
        }
        relationSet.add(usedSet);
    }
}
