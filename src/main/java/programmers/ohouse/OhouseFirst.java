package programmers.ohouse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OhouseFirst {
    public long solution(int N, int[] height) {
        long answer = height.length - 1;
        for (int i = 0; i < height.length - 2; i++) {
            for (int j = i + 2; j < height.length; j++) {
                int start = height[i];
                int end = height[j];
                boolean success = true;
                for (int k = i + 1; k < j; k++) {
                    if (height[k] >= start || height[k] >= end) {
                        success = false;
                        break;
                    }
                }
                if (success) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public long solution2(int N, int[] height) {
        long answer = height.length - 1;
        for (int i = 0; i < height.length - 2; i++) {
            int start = height[i];
            if (start > height[i + 1]) {
                for (int j = i + 2; j < height.length; j++) {
                    if (height[j] >= start) {
                        answer++;
                        break;
                    }
                    if (j == height.length - 1) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }


    public long solution3(int N, int[] height) {
        List<Integer> heightList = Arrays.stream(height).boxed().collect(Collectors.toList());
        List<List<Integer>> splitHeight = new ArrayList<>();
        int index = 0;
        while (index < heightList.size()) {

            int startIndex = index;
            int start = heightList.get(index);
            index++;
            while (index < heightList.size()) {
                if (heightList.get(index) >= start) {
                    splitHeight.add(heightList.subList(startIndex, index + 1));
                    break;
                } else {
                    index++;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < splitHeight.size(); i++) {
            List<Integer> splited = splitHeight.get(i);
            count += getBowlCount(splited.toArray(new Integer[0]));
        }
        return count;
    }

    public long getBowlCount(Integer[] height) {
        long answer = height.length - 1;
        for (int i = 0; i < height.length - 2; i++) {
            for (int j = i + 2; j < height.length; j++) {
                int start = height[i];
                int end = height[j];
                boolean success = true;
                for (int k = i + 1; k < j; k++) {
                    if (height[k] >= start || height[k] >= end) {
                        success = false;
                        break;
                    }
                }
                if (success) {
                    answer++;
                }
            }
        }
        return answer;
    }


}
