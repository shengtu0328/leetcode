package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: rqxiao
 * @Date: 2020-9-4 14:16
 * @Description: 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreePaths_256 {


    public static List<String> binaryTreePaths(TreeNode root) {


        String s = "";

        List<String> paths = new ArrayList<String>();

        constructPaths(root, s, paths);

        return paths;

    }

    public static void constructPaths(TreeNode root, String path, List<String> paths) {

        int val = root.val;

        path = path + val + "->";

        if (root.left == null && root.right == null) {
            paths.add(path);
        }
        if (root.left != null) {
            constructPaths(root.left, path, paths);
        }
        if (root.right != null) {
            constructPaths(root.right, path, paths);
        }

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {

        //构建二叉树
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        TreeNode node5 = new TreeNode(5);
        node2.right = node5;


        System.out.println(binaryTreePaths(node1));

    }

}
