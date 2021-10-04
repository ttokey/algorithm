package programmers.baemin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Baemin1 {
    public String solution(String message) {
        char[] messages = message.toCharArray();
        Node root = new Node(String.valueOf(messages[0]));
        for (int i = 1; i < messages.length; i++) {
            root.inputNode(new Node(String.valueOf(messages[i])));
        }
        return root.getPassword();
    }

    public class Node {
        String name;
        Node left;
        Node right;

        public Node(String name) {
            this.name = name;
            this.right = null;
            this.left = null;
        }

        public String getPassword() {
            Stack<Node> nodes = new Stack<>();
            nodes.add(this);
            StringBuilder sb = new StringBuilder();
            while (!nodes.isEmpty()) {
                Node node = nodes.pop();
                sb.append(node.name);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            return sb.reverse().toString();
        }

        public void inputNode(Node inputNode) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(this);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (node.left == null) {
                    node.left = inputNode;
                    break;
                } else if (node.right == null) {
                    node.right = inputNode;
                    break;
                } else {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
    }
}
