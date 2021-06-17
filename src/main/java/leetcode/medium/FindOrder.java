package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindOrder {
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) {
            return new int[]{0};
        }
        List<Integer> course = new ArrayList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int first = prerequisites[i][1];
            int second = prerequisites[i][0];
            if (!course.contains(first) && !course.contains(second)) {
                List<Integer> temp = new ArrayList<>();
                temp.addAll(course);
                course = new ArrayList<>();
                course.add(first);
                course.addAll(temp);
                course.add(second);
            } else if (!course.contains(first) && course.contains(second)) {
                List<Integer> temp = new ArrayList<>();
                temp.addAll(course);
                course = new ArrayList<>();
                course.add(first);
            } else if (course.contains(first) && !course.contains(second)) {
                course.add(second);
            } else {
                int firstIndex = course.indexOf(first);
                int secondIndex = course.indexOf(second);
                if (firstIndex > secondIndex) {
                    int temp = course.get(firstIndex);
                    course.set(firstIndex, course.get(secondIndex));
                    course.set(secondIndex, temp);
                }
            }
        }
        int[] result = course.stream()
                .mapToInt(i -> i.intValue())
                .toArray();
        return result;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> course = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            course.add(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int first = prerequisites[i][1];
            int second = prerequisites[i][0];
            int firstIndex = course.indexOf(first);
            int secondIndex = course.indexOf(second);
            if (firstIndex > secondIndex) {
                int temp = course.get(firstIndex);
                course.set(firstIndex, course.get(secondIndex));
                course.set(secondIndex, temp);
            }

        }
        int[] result = course.stream()
                .mapToInt(i -> i.intValue())
                .toArray();
        return result;
    }


}
