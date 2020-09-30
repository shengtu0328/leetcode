package tree;

/**
 * @Author: rqxiao
 * @Date: 2020-9-30 10:54
 * @Description: 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 * <p>
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InsertIntoABinarySearchTree_701 {


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


    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        BST(root, val);

        return root;
    }


    public void BST(TreeNode root, int val) {


        if (val < root.val) {
            if (root.left != null) {
                BST(root.left, val);
            } else {
                root.left = new TreeNode(val);
            }
        }


        if (val > root.val) {

            if (root.right != null) {
                BST(root.right, val);
            } else {
                root.right = new TreeNode(val);
            }


        }


    }


    public static void main(String[] args) {

        InsertIntoABinarySearchTree_701 i = new InsertIntoABinarySearchTree_701();

        TreeNode n4 = i.new TreeNode(4);
        TreeNode n2 = i.new TreeNode(2);
        TreeNode n7 = i.new TreeNode(7);
        TreeNode n1 = i.new TreeNode(1);
        TreeNode n3 = i.new TreeNode(3);

        n4.left = n2;
        n4.right = n7;

        n2.left = n1;
        n2.right = n3;


        TreeNode treeNode = i.insertIntoBST(n4, 5);
    }

}
