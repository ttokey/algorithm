package leetcode.hard;

public class RecoverFromPreorder {


    public TreeNode recoverFromPreorder(String traversal) {
        TreeNode rootNode = new TreeNode(Integer.parseInt(traversal.substring(0, 1)));
        nodeToMap(rootNode, traversal);
        return rootNode;
    }

    public void nodeToMap(TreeNode rootNode, String traversal) {
        int depth = 0;
        for (int i = 1; i < traversal.length(); i++) {
            if (Character.isDigit(traversal.charAt(i))) {
                inputNode(rootNode, Integer.parseInt(traversal.substring(i, i + 1)), 0, depth);
                depth = 0;
            } else {
                depth++;
            }
        }
    }

    public void inputNode(TreeNode nowNode, int value, int nowDepth, int targetDepth) {
        if (nowDepth + 1 == targetDepth) {
            TreeNode node = new TreeNode(value, null, null);
            if (nowNode.left == null) {
                nowNode.left = node;
                return;
            }
            if (nowNode.right == null) {
                nowNode.right = node;
                return;
            }
            return;
        }
        if (nowDepth + 1 < targetDepth) {
            if (nowNode.left != null) {
                inputNode(nowNode.left, value, nowDepth + 1, targetDepth);
            }
            if (nowNode.right != null) {
                inputNode(nowNode.right, value, nowDepth + 1, targetDepth);
            }
        }
        return;
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
