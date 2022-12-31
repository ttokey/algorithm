package programmers.practice.lv2;

import java.util.Arrays;

public class LifeBoat_42885 {
    public int solution(int[] people, int limit) {
        people = Arrays.stream(people).sorted().toArray();
        int low = 0, high = people.length - 1;
        int count = 0;
        while (high >= low) {
            if (people[high] + people[low] <= limit) {
                count++;
                high--;
                low++;
            } else {
                count++;
                high--;
            }
        }
        return count;
    }
}
