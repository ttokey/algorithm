package programmers.devMatching2;

import java.util.*;

public class MakeFood {
    public int solution(int n, String[] recipes, String[] orders) {
        FireBalls fireBalls = new FireBalls(n, recipes);
        int endTime = 0;
        for(String order : orders){
            endTime = fireBalls.inputCook(order);
        }
        return endTime;
    }

    public class FireBalls{
        private FireBall[] fireBalls;
        private Map<String, Integer> recipes = new HashMap<>();

        public FireBalls(int n, String[] recipes) {
            this.fireBalls = new FireBall[n];
            for(int i = 0; i < fireBalls.length ; i++){
                fireBalls[i] = new FireBall();
            }
            for(String recipe : recipes){
                String[] split = recipe.split(" ");
                this.recipes.put(split[0], Integer.valueOf(split[1]));
            }
        }

        public int inputCook(String orders){
            String[] order = orders.split(" ");
            int nowTime = Integer.valueOf(order[1]);

            int canCookBallIndex = findCanCookBall(nowTime);

            if(canCookBallIndex < 0){
                nowTime = nextCanCookTime();
                canCookBallIndex = findCanCookBall(nowTime);
            }

            fireBalls[canCookBallIndex].startCooking(nowTime, recipes.get(order[0]));
            return fireBalls[canCookBallIndex].endTime;
        }

        public int findCanCookBall(int nowTime){
            for(int i = 0 ; i < fireBalls.length ; i++){
                if(!fireBalls[i].isUsing(nowTime)){
                    return i;
                }
            }
            return -1;
        }

        public int nextCanCookTime(){
            List<Integer> endTimes = new ArrayList<>();
            for(FireBall fireBall : fireBalls){
                endTimes.add(fireBall.getEndTime());
            }
            endTimes.sort(Comparator.naturalOrder());
            return endTimes.get(0);
        }

    }

    public class FireBall{
        private int endTime;

        public FireBall() {
            this.endTime = -1;
        }

        public boolean isUsing(int nowTime){
            return nowTime < endTime ? true : false;
        }

        public int getEndTime(){
            return this.endTime;
        }

        public void startCooking(int startTime, int cookingTime){
            this.endTime = startTime + cookingTime;
        }
    }


}
