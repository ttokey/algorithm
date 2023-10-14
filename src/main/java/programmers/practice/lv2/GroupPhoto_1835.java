package programmers.practice.lv2;

import java.util.EnumSet;
import java.util.List;

public class GroupPhoto_1835 {
    public int solution(int n, String[] data) {
        int answer = 0;
        return answer;
    }

    public class Photo {
        public List<Friend[]> sortList;

        public Photo() {
            this.sortList = sortList;
        }

    }

    public enum Friend {
        APEACH("A"),
        CON("C"),
        FRODO("F"),
        JAY_G("J"),
        MUZI("M"),
        NEO("N"),
        RYAN("R"),
        TUBE("T"),
        ;

        public String first;

        Friend(String first) {
            this.first = first;
        }

        public static Friend of(String type) {
            return EnumSet.allOf(Friend.class).stream()
                    .filter(friend -> friend.first.equals(type))
                    .findFirst()
                    .get();
        }
    }
}
