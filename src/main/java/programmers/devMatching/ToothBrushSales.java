package programmers.devMatching;


//https://programmers.co.kr/learn/courses/30/lessons/77486

import java.util.ArrayList;
import java.util.List;

public class ToothBrushSales {
    public String CENTER = "-";

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(CENTER));

        for (String name : enroll) {
            nodes.add(new Node(name));
        }

        for (int i = 0; i < enroll.length; i++) {
            nodes.get(i + 1).addParent(findNode(referral[i], nodes));
        }

        for (int i = 0; i < seller.length; i++) {
            findNode(seller[i], nodes).plusProfit(amount[i] * 100);
        }

        nodes.remove(nodes.get(0));
        int[] answer = nodes.stream().mapToInt(node -> node.profit).toArray();
        return answer;
    }

    public Node findNode(String name, List<Node> nodes) {
        Node result = new Node("");
        for (Node node : nodes) {
            if (node.name.equals(name)) {
                result = node;
                break;
            }
        }
        return result;
    }

    public class Node {
        String name;
        int profit;
        Node parentNode;

        public Node(String name) {
            this.name = name;
        }

        public void addParent(Node parent) {
            this.parentNode = parent;
        }

        public void plusProfit(int profit) {
            this.profit += profit - profit / 10;
            if (!parentNode.name.equals(CENTER) && (profit / 10 > 0)) {
                parentNode.plusProfit(profit / 10);
            }
        }
    }
}
