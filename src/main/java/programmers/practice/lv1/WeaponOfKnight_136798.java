package programmers.practice.lv1;

public class WeaponOfKnight_136798 {
    public int solution(int number, int limit, int power) {
        int[] attackArray = new int[number];
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int index = 1;
            while (i * index <= number) {
                attackArray[i * index - 1]++;
                index++;
            }
        }
        for (int attack : attackArray) {
            if (attack <= limit) {
                answer += attack;
            } else {
                answer += power;
            }
        }
        return answer;
    }
}
