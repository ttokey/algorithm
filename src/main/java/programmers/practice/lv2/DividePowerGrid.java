package programmers.practice.lv2;

import java.util.ArrayList;
import java.util.List;

public class DividePowerGrid {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            PowerGrids powerGrids = new PowerGrids(n, wires, i);
            answer = Math.min(answer, powerGrids.getDiff());
        }
        return answer;
    }

    public class PowerGrids {
        List<PowerGrid> powerGrids = new ArrayList<>();
        int count = 0;

        public PowerGrids(int n, int[][] wires, int ignore) {
            for (int i = 0; i < n; i++) {
                powerGrids.add(new PowerGrid());
            }
            for (int i = 0; i < wires.length; i++) {
                if (i != ignore) {
                    PowerGrid left = powerGrids.get(wires[i][0] - 1);
                    PowerGrid right = powerGrids.get(wires[i][1] - 1);
                    left.addChild(right);
                    right.addChild(left);
                }
            }
        }

        public int getDiff() {
            doBFS(powerGrids.get(0));
            return Math.abs(powerGrids.size() - (count * 2));
        }

        private void doBFS(PowerGrid powerGrid) {
            count++;
            powerGrid.doCount();
            for (PowerGrid nextGrid : powerGrid.getChild()) {
                doBFS(nextGrid);
            }
        }


    }

    public class PowerGrid {
        List<PowerGrid> childPowerGrid = new ArrayList<>();
        boolean isCounted;

        public PowerGrid() {
            this.isCounted = false;
        }

        public void addChild(PowerGrid powerGrid) {
            this.childPowerGrid.add(powerGrid);
        }

        public List<PowerGrid> getChild() {
            List<PowerGrid> result = new ArrayList<>();
            for (PowerGrid child : childPowerGrid) {
                if (!child.isCounted) {
                    result.add(child);
                }
            }
            return result;
        }

        public void doCount() {
            this.isCounted = true;
        }
    }


}
