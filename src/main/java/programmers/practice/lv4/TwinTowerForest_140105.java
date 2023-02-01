package programmers.practice.lv4;

//자신 보다 작은 숫자만 들어올 수 있음.
//만들어 낼 수 있는 경우의 수를 먼저 만들어 보자
//굳이 만들어야 하나? 생각해보니 굳이 만들 필요는 없을 듯 함

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class TwinTowerForest_140105 {
    int result = 0;

    public int solution(int n, int count) {
        Towers towers = new Towers(n);
        View view = new View(count);
        dfs(towers, view);
        return result;
    }

    public void dfs(Towers towers, View view) {
        if (towers.isFinished() && view.isCorrectCount()) {
            result = (result + 1) % 1000000007;
            return;
        }

        List<Integer> getNextTowers = towers.getNextTower();
        for (int nextTower : getNextTowers) {
            if (view.canAddView(nextTower)) {
                Towers newTowers = (Towers) towers.clone();
                View newView = (View) view.clone();
                newTowers.addTower(nextTower);
                newView.addView(nextTower);
                dfs(newTowers, newView);
            }
        }
    }

    public class Towers implements Cloneable {
        int n;
        Map<Integer, Integer> ingredientTower = new HashMap<>();
        Stack<Integer> towerStack = new Stack<>();

        public Towers(int n) {
            this.n = n;
            //2개씩 사용 가능
            for (int i = 1; i <= n; i++) {
                ingredientTower.put(i, 2);
            }
        }

        public Towers(int n, Map<Integer, Integer> ingredientTower, Stack<Integer> towerStack) {
            this.n = n;
            this.ingredientTower = new HashMap<>();
            this.towerStack = new Stack<>();
            for (Integer key : ingredientTower.keySet()) {
                this.ingredientTower.put(key, ingredientTower.get(key));
            }
            for (Integer input : towerStack) {
                this.towerStack.add(input);
            }
        }

        public void addTower(int height) {
            if (!towerStack.isEmpty() && towerStack.peek() == height && ingredientTower.get(height) == 1) {
                towerStack.pop();
                ingredientTower.remove(height);
            } else {
                towerStack.add(height);
                ingredientTower.put(height, 1);
            }
        }

        public List<Integer> getNextTower() {
            List<Integer> result = new ArrayList<>();
            if (towerStack.isEmpty()) {
                return ingredientTower.keySet().stream().collect(Collectors.toList());
            } else {
                for (int i = 1; i <= towerStack.peek(); i++) {
                    if (ingredientTower.containsKey(i)) {
                        result.add(i);
                    }
                }
            }
            return result;
        }

        public boolean isFinished() {
            return ingredientTower.isEmpty();
        }

        @Override
        protected Towers clone() {
            Towers result = new Towers(this.n, this.ingredientTower, this.towerStack);
            return result;
        }
    }

    public class View implements Cloneable {
        Stack<Integer> sawing = new Stack<>();
        int count;

        public View(int count) {
            this.count = count;
        }

        public View(Stack<Integer> sawing, int count) {
            this.sawing = (Stack<Integer>) sawing.clone();
            this.count = count;
        }

        public boolean canAddView(int height) {
            if (sawing.isEmpty() || sawing.size() < count || sawing.peek() >= height) {
                return true;
            }
            return false;
        }

        public void addView(int height) {
            if (sawing.isEmpty() || sawing.peek() < height) {
                sawing.add(height);
            }
        }

        public boolean isCorrectCount() {
            return sawing.size() == count;
        }

        @Override
        public View clone() {
            View result = new View(this.sawing, this.count);
            return result;
        }
    }


}
