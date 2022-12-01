package programmers.practice.lv2;

import java.util.ArrayList;
import java.util.List;

public class NightTacticalWalking_133501 {
    public int solution(int distance, int[][] scope, int[][] times) {
        Guards guards = new Guards(scope, times);
        for (int location = 1; location <= distance; location++) {
            if (guards.isGuardWork(location)) {
                return location;
            }
        }
        return distance;
    }

    public class Guards {
        private List<Guard> guardList = new ArrayList<>();

        public Guards(int[][] scope, int[][] times) {
            for (int i = 0; i < scope.length; i++) {
                Guard guard = new Guard(scope[i], times[i]);
                guardList.add(guard);
            }
        }

        public boolean isGuardWork(int location) {
            for (Guard guard : guardList) {
                if (guard.isGuardWork(location)) {
                    return true;
                }
            }
            return false;
        }
    }

    public class Guard {
        private int[] scope;
        private int[] times;

        public Guard(int[] scope, int[] times) {
            this.scope = scope;
            this.times = times;
        }

        public boolean isGuardWork(int location) {
            if (this.isInScope(location)) {
                if (this.isWork(location)) {
                    return true;
                }
            }
            return false;
        }

        private boolean isInScope(int location) {
            return (location >= scope[0] && location <= scope[1])
                    || (location >= scope[1] && location <= scope[0]);
        }

        private boolean isWork(int time) {
            int sumTime = times[0] + times[1];
            if (time % sumTime > 0 && time % sumTime <= times[0]) {
                return true;
            } else {
                return false;
            }
        }
    }
}
