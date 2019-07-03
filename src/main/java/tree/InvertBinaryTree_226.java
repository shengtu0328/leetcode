package tree;

/**
 * @Auther: rqxiao
 * @Date: 2019-7-1 17:04
 * @Description:
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InvertBinaryTree_226 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    public  static TreeNode invertTree(TreeNode root) {


        if (root == null ) {                              //与461题类似，二叉树题目的本质是什么?递归！！
            return null;
        }
        // 先合并根节点
        TreeNode treeNode = new TreeNode(root.val);
        // 再递归合并左右子树
        treeNode.left = invertTree(root.right == null ? null : root.right);
        treeNode.right = invertTree(root.left == null ? null : root.left);
        return treeNode;

    }


    public static void main(String[] args) {
        TreeNode t4=new TreeNode(4);

        TreeNode t2=new TreeNode(2);
        TreeNode t1=new TreeNode(1);
        TreeNode t3=new TreeNode(3);

        TreeNode t7=new TreeNode(7);
        TreeNode t6=new TreeNode(6);
        TreeNode t9=new TreeNode(9);

        t4.left=t2;
        t4.right=t7;

        t2.left=t1;
        t2.right=t3;

        t7.left=t6;
        t7.right=t9;


        TreeNode treeNode = InvertBinaryTree_226.invertTree(t4);
        System.out.println(treeNode);

    }
}
