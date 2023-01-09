package programmers.practice.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoyStick_42860 {
    public int solution(String name) {
        List<Integer> upDownCountList = new ArrayList<>();
        for (int i = 0; i < name.length(); i++) {
            upDownCountList.add(findUpDownCount(name.charAt(i)));
        }
        return Math.min(dp(0, true, upDownCountList, 0),
                dp(0, false, upDownCountList, 0));
    }

    public int dp(int index, boolean direction, List<Integer> upDownCountList, int count) {
        if (isAllZero(upDownCountList)) {
            return count;
        }
        int[] upDownCountArray = upDownCountList.stream().mapToInt(i -> i).toArray();
        count += upDownCountArray[index];
        upDownCountArray[index] = 0;
        while (upDownCountArray[index] == 0) {
            if (direction) {
                index = (index + upDownCountList.size() + 1) % upDownCountList.size();
            } else {
                index = (index + upDownCountList.size() - 1) % upDownCountList.size();
            }
            count++;
        }
        while (upDownCountArray[index] != 0) {
            count += upDownCountArray[index];
            upDownCountArray[index] = 0;
            if (direction) {
                index = (index + upDownCountList.size() + 1) % upDownCountList.size();
            } else {
                index = (index + upDownCountList.size() - 1) % upDownCountList.size();
            }
            count++;
        }
        if (direction) {
            index = (index + upDownCountList.size() - 1) % upDownCountList.size();
        } else {
            index = (index + upDownCountList.size() + 1) % upDownCountList.size();
        }
        count--;

        List<Integer> toList = Arrays.stream(upDownCountArray).boxed().collect(Collectors.toList());

        return Math.min(dp(index, true, toList, count), dp(index, false, toList, count));
    }


    public boolean isAllZero(List<Integer> upDownCountList) {
        return upDownCountList.stream().filter(i -> i != 0).findAny().isEmpty();
    }

    public int findUpDownCount(char target) {
        return Math.min(target - 'A', 26 - target + 'A');
    }
}
