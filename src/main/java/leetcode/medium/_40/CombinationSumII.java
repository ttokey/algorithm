package leetcode.medium._40;

import java.util.*;

public class CombinationSumII {
    int[] candidates;
    int target;
    boolean[] enableCandidates;
    Set<List<Integer>> result = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = Arrays.stream(candidates).sorted().toArray();
        this.target = target;
        this.enableCandidates = new boolean[candidates.length];
        findCombination(0, 0);
        return new ArrayList<>(result);
    }

    public void findCombination(int index, int sumOfCandidates) {
        if (index >= candidates.length) {
            return;
        }

        if (sumOfCandidates + candidates[index] > target) {
            return;
        } else if (sumOfCandidates + candidates[index] == target) {
            enableCandidates[index] = true;
            result.add(fetchEnableCandidates());
            enableCandidates[index] = false;
            return;
        } else {
            enableCandidates[index] = true;
            findCombination(index + 1, sumOfCandidates + candidates[index]);
            enableCandidates[index] = false;
            while (index + 1 < candidates.length && candidates[index + 1] == candidates[index]) {
                index++;
            }
            findCombination(index + 1, sumOfCandidates);
        }

    }

    public List<Integer> fetchEnableCandidates() {
        List<Integer> enableCandidateList = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            if (enableCandidates[i]) {
                enableCandidateList.add(candidates[i]);
            }
        }
        return enableCandidateList;
    }
}
