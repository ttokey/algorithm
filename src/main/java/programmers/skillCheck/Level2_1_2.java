package programmers.skillCheck;

import java.util.HashSet;
import java.util.Set;

public class Level2_1_2 {
    public int solution(int[] A, int[] B) {
        DFS dfs = new DFS(A, B);

        int answer = dfs.minSum;
        return answer;
    }

    public class DFS {
        int[] A;
        int[] B;
        int sum;
        int minSum;
        Set<Integer> setA;
        Set<Integer> setB;

        public DFS(int[] a, int[] b) {
            A = a;
            B = b;
            this.sum = 0;
            this.minSum = Integer.MAX_VALUE;
            this.setA = new HashSet<>();
            this.setB = new HashSet<>();
        }

        public void find() {
            
        }
    }
}
