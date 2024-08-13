package leetcode.easy.P703;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class KthLargest {
    List<Integer> numList = new LinkedList<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.numList = Arrays.stream(nums)
                .boxed()
                .sorted(Collections.reverseOrder())
                .limit(k)
                .collect(Collectors.toList());
        this.k = k;
    }

    public int add(int val) {
        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) <= val) {
                numList.add(i, val);
                break;
            }
        }
        if (numList.size() < k) {
            numList.add(val);
        }
        return numList.get(k - 1);
    }
}
