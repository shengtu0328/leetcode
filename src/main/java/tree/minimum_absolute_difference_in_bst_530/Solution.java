package tree.minimum_absolute_difference_in_bst_530;

import tree.TreeNode;

/**
 * 你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * 输出：
 * 1
 * <p>
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    int pre = -1;
    int ans = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {


        zhongxubianli(root);
        return ans;
    }


    public void zhongxubianli(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        zhongxubianli(treeNode.left);

        int val = treeNode.val;

        if (pre == -1) {
            pre = val;
        } else {
            ans = Math.min(val - pre, ans);
            pre = val;
        }
        zhongxubianli(treeNode.right);

    }

    public static void main(String[] args) {
        //构建二叉树
        TreeNode node1 = new TreeNode(1);
        TreeNode node9 = new TreeNode(9);


        node1.left = null;
        node1.right = node9;

        TreeNode node3 = new TreeNode(3);
        node9.left = node3;

        Solution solution = new Solution();
        System.out.println(solution.getMinimumDifference(node1));

    }

}
