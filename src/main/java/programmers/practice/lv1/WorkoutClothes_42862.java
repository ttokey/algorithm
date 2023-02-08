package programmers.practice.lv1;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class WorkoutClothes_42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new TreeSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        Set<Integer> removeLost = new HashSet<>();
        for (int r : reserve) {
            reserveSet.add(r);
        }
        for (int lo : lost) {
            if (reserveSet.contains(lo)) {
                reserveSet.remove(lo);
            } else {
                lostSet.add(lo);
            }
        }
        for (int lo : lostSet) {
            if (reserveSet.contains(lo - 1)) {
                reserveSet.remove(lo - 1);
                removeLost.add(lo);
            } else if (reserveSet.contains(lo + 1)) {
                reserveSet.remove(lo + 1);
                removeLost.add(lo);
            }
        }
        return n - lostSet.size() + removeLost.size();
    }
}
