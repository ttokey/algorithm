package programmers.practice.lv2;

import java.util.PriorityQueue;

public class DefenseGame_142085 {
    public int solution(int n, int k, int[] enemies) {
        int result = enemies.length;
        Strategy strategy = new Strategy(n, k);
        for (int i = 0; i < enemies.length; i++) {
            if (!strategy.addEnemy(enemies[i])) {
                result = i;
                break;
            }
        }
        return result;
    }

    public class Strategy {
        int soldier;
        int invincibility;
        PriorityQueue<Integer> enemyQueue;

        public Strategy(int soldier, int invincibility) {
            this.soldier = soldier;
            this.invincibility = invincibility;
            this.enemyQueue = new PriorityQueue<>((a, b) -> b - a);
        }

        public boolean addEnemy(int enemy) {
            if (soldier >= enemy) {
                enemyQueue.add(enemy);
                soldier -= enemy;
                return true;
            } else {
                if (invincibility > 0 && !enemyQueue.isEmpty()) {
                    if (enemyQueue.peek() < enemy) {
                        invincibility--;
                        return true;
                    } else {
                        soldier += enemyQueue.poll();
                        invincibility--;
                        return addEnemy(enemy);
                    }
                } else if (invincibility == 0) {
                    return false;
                }
            }
            invincibility--;
            return true;
        }
    }
}
