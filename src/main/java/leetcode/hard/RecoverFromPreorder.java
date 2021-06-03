package leetcode.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RecoverFromPreorder {


    public TreeNode recoverFromPreorder(String traversal) {
        List<Queue<Integer>> tree = new ArrayList<>();


        TreeNode rootNode = new TreeNode();
        return null;
    }

    public List<Queue<Integer>> nodeToMap(String traversal) {
        List<Queue<Integer>> result = new ArrayList<>();
        int maxDepth = getMaxDepth(traversal);
        for (int i = 0; i <= maxDepth; i++) {
            Queue<Integer> temp = new LinkedList<>();
            result.add(i, temp);
        }
        int depth = 0;
        for (int i = 0; i < traversal.length(); i++) {
            if (Character.isDigit(traversal.charAt(i))) {
                result.get(depth).add(Integer.parseInt(traversal.substring(i, i + 1)));
                depth = 0;
            } else {
                depth++;
            }
        }
        return result;
    }

    public TreeNode inputNode(TreeNode route, int value, int depth) {
        

    }

    public int getMaxDepth(String traversal) {
        int maxDepth = 0;
        int depth = 0;
        for (int i = 0; i < traversal.length(); i++) {
            if (Character.isDigit(traversal.charAt(i))) {
                if (depth > maxDepth) {
                    maxDepth = depth;
                }
                depth = 0;
            } else {
                depth++;
            }
        }
        return maxDepth;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
