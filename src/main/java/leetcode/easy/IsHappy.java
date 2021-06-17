package leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IsHappy {
    public boolean isHappy(int n) {
        List<Integer> happyList = new ArrayList<>();
        Set<Integer> happySet = new HashSet<>();

        while (happyList.size() == happySet.size()) {
            happyList.add(n);
            happySet.add(n);
            n = nextN(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    public int nextN(int n) {
        int result = 0;
        String input = String.valueOf(n);
        for (int i = 0; i < input.length(); i++) {
            int temp = Integer.parseInt(input.substring(i, i + 1));
            result += Math.pow(temp, 2);
        }
        return result;
    }

}
