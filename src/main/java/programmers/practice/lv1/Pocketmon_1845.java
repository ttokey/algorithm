package programmers.practice.lv1;

import java.util.HashSet;
import java.util.Set;

public class Pocketmon_1845 {
    public int solution(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }
        return s.size() > nums.length / 2 ? nums.length / 2 : s.size();
    }
}
