package programmers.practice;

public class FoodFight_134240 {
    public String solution(int[] food) {
        StringBuilder front = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            for (int j = 0; j < count; j++) {
                front.append(i);
            }
        }
        return front.toString() + "0" + front.reverse().toString();
    }
}
