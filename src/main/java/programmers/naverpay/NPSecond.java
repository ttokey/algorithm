package programmers.naverpay;

public class NPSecond {
    int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean[][] canVisit;


    public int[] solution(int n, int jump) {
        canVisit = new boolean[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                canVisit[i][j] = true;
            }
        }

        Node[] nodeList = new Node[n * n];

        int nowDirection = 0;
        int X = 1;
        int Y = 1;

        nodeList[0] = new Node(X, Y);
        for (int i = 1; i < n * n; i++) {
            int nextX = X + direction[nowDirection][0];
            int nextY = Y + direction[nowDirection][1];

            if (!canVisit[nextX][nextY]) {
                nowDirection = (nowDirection + 1) % 4;
                nextX = X + direction[nowDirection][0];
                nextY = Y + direction[nowDirection][1];
            }
            canVisit[nextX][nextY] = false;
            nodeList[i] = new Node(nextX, nextY);
            X = nextX;
            Y = nextY;
        }

        boolean[] visitList = new boolean[n * n];

        int nowIndex = 0;
        int count = 1;

        visitList[nowIndex] = true;
        int[] answer = new int[2];

        while (count < n * n) {
            count++;
            int jumpCount = 0;
            while (jumpCount < jump) {
                nowIndex = (nowIndex + 1) % (n * n);
                while (visitList[nowIndex]) {
                    nowIndex = (nowIndex + 1) % (n * n);
                }
                jumpCount++;
            }
            visitList[nowIndex] = true;
        }
        answer[0] = nodeList[nowIndex].x;
        answer[1] = nodeList[nowIndex].y;
        return answer;
    }


    public class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
