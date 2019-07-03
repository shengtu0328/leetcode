package tree;

/**
 * @Auther: rqxiao
 * @Date: 2019-6-28 16:36
 * @Description:
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoBinaryTrees_617 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if(t1==null&&t2==null){
            return null;
        }


        TreeNode treeNode=new TreeNode(((t1==null)?0:t1.val)+((t2==null)?0:t2.val));


        treeNode.left=mergeTrees(t1==null?null:t1.left,t2==null?null:t2.left);
        treeNode.right=mergeTrees(t1==null?null:t1.right,t2==null?null:t2.right);

        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode t1_1=new TreeNode(1);
        TreeNode t1_3=new TreeNode(3);
        TreeNode t1_2=new TreeNode(2);
        TreeNode t1_5=new TreeNode(5);
        t1_1.left=t1_3;
        t1_1.right=t1_2;
        t1_3.left=t1_5;

        TreeNode t2_2=new TreeNode(2);
        TreeNode t2_1=new TreeNode(1);
        TreeNode t2_3=new TreeNode(3);
        TreeNode t2_4=new TreeNode(4);
        TreeNode t2_7=new TreeNode(7);
        t2_2.left=t2_1;
        t2_2.right=t2_3;
        t2_1.right=t2_4;
        t2_3.right=t2_7;

        TreeNode treeNode = MergeTwoBinaryTrees_617.mergeTrees(t1_1, t2_2);
        System.out.println(treeNode);

    }
}
