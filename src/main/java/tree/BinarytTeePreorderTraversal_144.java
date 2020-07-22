package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: rqxiao
 * @Date: 2020-7-22 14:58
 * @Description: 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 */
public class BinarytTeePreorderTraversal_144 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static List<Integer> list = new ArrayList<Integer>();


    public static List<Integer> preorderTraversal(TreeNode root) {

        if (root != null) {
            System.out.println(root.val);
            list.add(root.val);

            preorderTraversal(root.left);


            preorderTraversal(root.right);


        }

        return list;

    }


    public static void main(String[] args) {

        TreeNode t3 = new TreeNode(3);


        TreeNode t2 = new TreeNode(2);
        t2.left = t3;

        TreeNode t1 = new TreeNode(1);
        t1.right = t2;

        List<Integer> list = preorderTraversal(t1);
        System.out.println(list);

    }
}
