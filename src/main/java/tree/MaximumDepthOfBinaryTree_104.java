package tree;

/**
 * @Auther: rqxiao
 * @Date: 2019-7-3 13:12
 * @Description:
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3                 最上层
 *    / \
 *   9  20               第二层
 *     /  \
 *    15   7             第三层
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class MaximumDepthOfBinaryTree_104 {

    /*
    *.
        求一颗数的最大深度 等于 这一颗树下一层的最大深度+1，null层算0
        依次类推（大问题分成小问题  递归）

    */

  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    public static int maxDepth(TreeNode root) {

      if(root==null)
          return 0;


        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        return Math.max(l,r)+1;

    }


    public static void main(String[] args) {
        TreeNode t3=new TreeNode(3);
        TreeNode t9=new TreeNode(9);
        TreeNode t20=new TreeNode(20);
        t3.left=t9;
        t3.right=t20;

        TreeNode t15=new TreeNode(15);
        TreeNode t7=new TreeNode(7);
        t20.left=t15;
        t20.right=t7;

        System.out.println(MaximumDepthOfBinaryTree_104.maxDepth(t3));


    }


}
