package programmers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FarNode {
    public int solution(int n, int[][] edge) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();

        for (int i = 0; i < edge.length; i++) {
            Integer first = edge[i][0];
            Integer second = edge[i][1];
            indexMap.merge(edge[i][0], Arrays.asList(edge[i][1]), (value, putValue) -> Stream.concat(value.stream(), Arrays.asList(second).stream()).collect(Collectors.toList()));
            indexMap.merge(edge[i][1], Arrays.asList(edge[i][0]), (value, putValue) -> Stream.concat(value.stream(), Arrays.asList(first).stream()).collect(Collectors.toList()));
        }
        int answer = BFS(indexMap);
        return answer;
    }

    public int BFS(Map<Integer, List<Integer>> indexMap) {
        int depth = 0;
        List<Integer> farNodeList = new ArrayList<>();
        Map<Integer, Boolean> visitedNode = new HashMap<>();
        for (int key : indexMap.keySet()) {
            visitedNode.put(key, true);
        }
        Queue<Node> bfs = new LinkedList<>();
        bfs.add(new Node(1, 0));
        visitedNode.put(1, false);
        while (!bfs.isEmpty()) {
            Node nowNode = bfs.poll();
            int nowIndex = nowNode.getIndex();
            int nowDepth = nowNode.getDepth();
            List<Integer> friendNodeList = indexMap.get(nowIndex);
            for (int index : friendNodeList) {
                if (indexMap.containsKey(index) && visitedNode.get(index)) {
                    bfs.add(new Node(index, nowDepth + 1));
                    visitedNode.put(index, false);
                    if (nowDepth + 1 > depth) {
                        depth = nowDepth + 1;
                        farNodeList = new ArrayList<>();
                    }
                    farNodeList.add(index);
                }
            }
        }
        return farNodeList.size();
    }

    class Node {
        int index;
        int depth;

        public Node(int index, int depth) {
            this.index = index;
            this.depth = depth;
        }

        public int getDepth() {
            return this.depth;
        }

        public int getIndex() {
            return this.index;
        }

    }
}
