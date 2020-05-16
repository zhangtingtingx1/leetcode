/*
 *给定两个二叉树，编写一个函数来检验它们是否相同。
*/

/*
* 递归的思路很容易想到，递归的重点是 1. 明确结束条件； 2. 递归的判断条件。
*/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //递归结束条件，直至叶子节点
        if (p == null && q == null) return true;
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
