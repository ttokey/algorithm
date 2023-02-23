package programmers.practice.lv1;

import java.util.stream.IntStream;

public class FindKimAtSeoul_12919 {
    public String solution(String[] seoul) {
        return String.format("김서방은 %d에 있다", IntStream.range(0, seoul.length).filter(i -> seoul[i].equals("Kim")).findFirst().getAsInt());
    }
}
