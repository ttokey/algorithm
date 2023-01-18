package programmers.practice.lv1;

public class Babbling_133499 {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String babb : babbling) {
            if (isCanBabbling(babb, "")) {
                answer++;
            }
        }
        return answer;
    }

    public boolean isCanBabbling(String babbling, String lastBabbString) {
        if (babbling.length() == 0) {
            return true;
        }
        String[] canBabbling = {"aya", "ye", "woo", "ma"};
        for (String babb : canBabbling) {
            if (!babb.equals(lastBabbString)) {
                if (babbling.startsWith(babb)) {
                    return isCanBabbling(babbling.substring(babb.length()), babb);
                }
            }
        }
        return false;
    }
}
