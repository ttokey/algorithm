package programmers.lineFinance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lineFinanceThird {
    public int[] solution(int n, int k) {
        if (k == 1) {
            return new int[]{1, 1};
        }
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(0, 0));

        for (int i = 2; i <= k; i++) {
            DistanceMap distanceMap = new DistanceMap(n, nodes);
            nodes.add(distanceMap.getNextNode());
        }
        Node lastNode = nodes.get(nodes.size() - 1);

        return new int[]{lastNode.y + 1, lastNode.x + 1};
    }

    public class DistanceMap {
        int[][] distanceMap;

        public DistanceMap(int n, List<Node> nodes) {
            this.distanceMap = new int[n][n];

            for (Node node : nodes) {
                this.distanceMap[node.x][node.y] = -1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (this.distanceMap[i][j] != -1) {
                        int minDistance = Integer.MAX_VALUE;
                        for (Node node : nodes) {
                            minDistance = Math.min(minDistance, node.distance(i, j));
                        }
                        distanceMap[i][j] = minDistance;
                    }
                }
            }
        }

        public Node getNextNode() {
            int maxDistance = -1;
            List<Node> maxDistanceNode = new ArrayList<>();
            for (int i = 0; i < distanceMap.length; i++) {
                for (int j = 0; j < distanceMap.length; j++) {
                    if (maxDistance < distanceMap[i][j]) {
                        maxDistance = distanceMap[i][j];
                        maxDistanceNode = new ArrayList<>();
                        maxDistanceNode.add(new Node(i, j));
                    } else if (maxDistance == distanceMap[i][j]) {
                        maxDistanceNode.add(new Node(i, j));
                    }
                }
            }
            Collections.sort(maxDistanceNode, (a, b) -> a.x < b.x ? -1 : 0);
            return maxDistanceNode.get(0);
        }


    }

    public class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distance(int inputX, int inputY) {
            return Math.abs(inputX - x) + Math.abs(inputY - y);
        }
    }

}
