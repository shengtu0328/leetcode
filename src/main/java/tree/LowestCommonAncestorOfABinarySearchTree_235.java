package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: rqxiao
 * @Date: 2020-9-27 14:19
 * @Description: 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LowestCommonAncestorOfABinarySearchTree_235 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> listP = new ArrayList<>();

    public List<TreeNode> listQ = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();

        List<TreeNode> pathPP = getPath(root, p, pathP);


        List<TreeNode> pathQ = new ArrayList<>();

        List<TreeNode> pathQQ = getPath(root, q, pathQ);


        TreeNode ancestor = null;
        for (int i = 0; i < pathPP.size() && i < pathQQ.size(); i++) {


            if (pathPP.get(i).val == pathQQ.get(i).val) {
                ancestor = pathPP.get(i);
            }

        }
        return ancestor;
    }


    public List<TreeNode> getPath(TreeNode root, TreeNode target, List<TreeNode> path) {

        path.add(root);

        if (root.val == target.val) {
            return path;
        }

        if (root.val > target.val) {

            getPath(root.left, target, path);
        }
        if (root.val < target.val) {
            getPath(root.right, target, path);
        }

        return path;
    }


    public static void main(String[] args) {


        LowestCommonAncestorOfABinarySearchTree_235 l = new LowestCommonAncestorOfABinarySearchTree_235();

        TreeNode root = l.new TreeNode(6);


        TreeNode t2 = l.new TreeNode(2);

        TreeNode t0 = l.new TreeNode(0);

        TreeNode t4 = l.new TreeNode(4);
        TreeNode t3 = l.new TreeNode(3);
        TreeNode t5 = l.new TreeNode(5);


        root.left = t2;
        t2.left = t0;
        t2.right = t4;
        t4.left = t3;
        t4.right = t5;

        TreeNode t8 = l.new TreeNode(8);
        TreeNode t7 = l.new TreeNode(7);
        TreeNode t9 = l.new TreeNode(9);

        root.right = t8;

        t8.left = t7;
        t8.right = t9;


        TreeNode treeNode = l.lowestCommonAncestor(root, t2, t4);


    }


}
