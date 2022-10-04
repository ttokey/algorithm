package leetcode.easy.pathsum;

public class PathSum {

    boolean isSame = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return isSame;
        } else {
            sumRecur(root, targetSum, 0);
        }
        return isSame;
    }

    public void sumRecur(TreeNode node, int targetSum, int nowSum) {
        int sumNum = nowSum + node.val;
        if (sumNum == targetSum && node.left == null && node.right == null) {
            isSame = true;
        } else {
            if (node.left != null) {
                sumRecur(node.left, targetSum, sumNum);
            }
            if (node.right != null) {
                sumRecur(node.right, targetSum, sumNum);
            }
        }
    }
}
