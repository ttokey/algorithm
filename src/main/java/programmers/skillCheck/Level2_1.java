package programmers.skillCheck;

public class Level2_1 {
    public int solution(int[] A, int[] B) {
        DFS dfs = new DFS(A, B);
        for (int i = 0; i < B.length; i++) {
            dfs.find(0, i);
        }
        int answer = dfs.minSum;
        return answer;
    }

    public class DFS {
        boolean[] A_visit;
        boolean[] B_visit;
        int[] A;
        int[] B;
        int sum;
        int minSum;

        public DFS(int[] A, int[] B) {
            this.A = A;
            this.B = B;
            A_visit = new boolean[A.length];
            B_visit = new boolean[B.length];
            sum = 0;
            minSum = Integer.MAX_VALUE;
        }

        public void find(int indexA, int indexB) {
            int temp = A[indexA] * B[indexB];
            sum += temp;
            A_visit[indexA] = true;
            B_visit[indexB] = true;
            if (isFinish()) {
                minSum = Math.min(sum, minSum);
            }

            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B.length; j++) {
                    if (!A_visit[i] && !B_visit[j] && (i != indexA || j != indexB)) {
                        find(i, j);
                    }
                }
            }

            sum -= temp;
            A_visit[indexA] = false;
            B_visit[indexB] = false;
        }

        public boolean isFinish() {
            int count = 0;
            for (int i = 0; i < A_visit.length; i++) {
                if (A_visit[i]) {
                    count++;
                }
            }
            return count == A_visit.length ? true : false;
        }
    }

}
