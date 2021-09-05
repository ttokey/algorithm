package programmers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FarNode {
    public int solution(int n, int[][] edge) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Integer first = edge[i][0];
            Integer second = edge[i][1];
            indexMap.merge(edge[i][0], Arrays.asList(edge[i][1]), (v1, v2) -> Stream.concat(v1.stream(), Arrays.asList(second).stream()).collect(Collectors.toList()));
            indexMap.merge(edge[i][1], Arrays.asList(edge[i][0]), (v1, v2) -> Stream.concat(v1.stream(), Arrays.asList(first).stream()).collect(Collectors.toList()));
        }
        int answer = BFS(indexMap);
        return answer;
    }

    public int BFS(Map<Integer, List<Integer>> indexMap) {
        int depth = 0;
        List<Integer> farNodeList = new ArrayList<>();
        Queue<Node> bfs = new LinkedList<>();
        bfs.add(new Node(1, 0));

        while (!bfs.isEmpty()) {
            Node nowNode = bfs.poll();
            int nowIndex = nowNode.getIndex();
            int nowDepth = nowNode.getDepth();
            if (indexMap.containsKey(nowIndex)) {
                List<Integer> friendNodeList = indexMap.get(nowIndex);
                for (int index : friendNodeList) {
                    if (indexMap.containsKey(index)) {
                        bfs.add(new Node(index, nowDepth + 1));
                        indexMap.remove(index);
                        if (nowDepth + 1 > depth) {
                            farNodeList = new ArrayList<>();
                        }
                        farNodeList.add(index);
                    }
                }
            }
        }
        return farNodeList.size();
    }

    class Node {
        int index;
        int depth;

        public Node() {
            this.depth = 0;
        }

        public Node(int index, int depth) {

        }

        public int getDepth() {
            return this.depth;
        }

        public int getIndex() {
            return this.index;
        }

    }
}
