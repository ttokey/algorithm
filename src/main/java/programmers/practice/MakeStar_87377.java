package programmers.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class MakeStar_87377 {
    public String[] solution(int[][] line) {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        Set<int[]> pointList = new HashSet<>();

        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Optional<int[]> meetPoint = getMeetPoint(line[i], line[j]);
                if (meetPoint.isPresent()) {
                    maxX = Math.max(maxX, meetPoint.get()[0]);
                    maxY = Math.max(maxY, meetPoint.get()[1]);
                    minX = Math.min(minX, meetPoint.get()[0]);
                    minY = Math.min(minY, meetPoint.get()[1]);
                    pointList.add(meetPoint.get());
                }
            }
        }

        List<String> answer = new ArrayList<>();
        for (int y = minY; y <= maxY; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = minX; x <= maxX; x++) {
                sb.append(".");
            }
            answer.add(sb.toString());
        }

        for (int[] point : pointList) {
            char[] chars = answer.get(point[1] - minY).toCharArray();
            chars[point[0] - minX] = '*';
            answer.set(point[1] - minY, String.copyValueOf(chars));
        }

        Collections.reverse(answer);
        return answer.toArray(String[]::new);
    }

    public Optional<int[]> getMeetPoint(int[] line1, int[] line2) {
        long denominator = (long) line1[0] * (long) line2[1] - (long) line1[1] * (long) line2[0];
        long numeratorX = (long) line1[1] * (long) line2[2] - (long) line1[2] * (long) line2[1];
        long numeratorY = (long) line1[2] * (long) line2[0] - (long) line1[0] * (long) line2[2];

        if (denominator == 0 || numeratorX % denominator != 0 || numeratorY % denominator != 0) {
            return Optional.empty();
        }

        int[] result = {(int) (numeratorX / denominator), (int) (numeratorY / denominator)};

        return Optional.of(result);
    }
}
