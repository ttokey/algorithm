package programmers.practice.lv2;

public class CarPoolTaxi {
    int[][] path;
    boolean[] visitedA;
    boolean[] visitedB;
    int start;
    int endA;
    int endB;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        initializing(n, s, a, b, fares);

        int answer = 0;
        return answer;
    }

    public void dfs() {

    }

    public class Node {
        private int nowA;
        private int nowB;
        private int peeA;
        private int peeB;
        private int peeAB;

        public Node(int nowA, int nowB, int peeA, int peeB, int peeAB) {
            this.nowA = nowA;
            this.nowB = nowB;
            this.peeA = peeA;
            this.peeB = peeB;
            this.peeAB = peeAB;
        }

        public int nowPee() {
            return peeA + peeB - peeAB;
        }

        public boolean isFinished() {
            if (nowA == endA && nowB == endB) {
                return true;
            }
            return false;
        }

    }

    public void initializing(int n, int s, int a, int b, int[][] fares) {
        path = new int[n][n];
        visitedA = new boolean[n];
        visitedB = new boolean[n];

        start = s;
        endA = a;
        endB = b;

        for (int i = 0; i < fares.length; i++) {
            path[fares[i][0]][fares[i][1]] = fares[i][2];
            path[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        for (int i = 0; i < n; i++) {
            visitedA[i] = false;
            visitedB[i] = false;
        }
    }
}
