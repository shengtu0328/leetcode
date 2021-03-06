package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: rqxiao
 * @Date: 2020-9-4 14:16
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * 通过次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeLevelOrderTraversal_102 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 此题为二叉树的bfs题目
     * 想法：
     * 想办法存储二叉树的出现的每一层节点，然后输出，此解法是用一个队列去存
     *
     * 做法：
     * 第一步先把根节点放入队列
     * 1.接着依次顺序遍历此次的队列（遍历指在队列中弹出节点并拿到val）    注意：长度按照当前队列的长度遍历,因为此次遍历中，当前层中的一个节点遍历后，会将它下一层的节点放进来
     * 2.并且此节点如果下层的话，将下一层的左边节点右节点依次放入队列，直到这一层的节点遍历完
     *
     * 然后开始循环此操作 1，2，直到队列为空结束
     *
     * 这样就能达到bfs的输出效果
     *
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.offer(root);
        }

        while ((queue.size() > 0)) {

            List<Integer> list = new ArrayList<>();

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);

                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            result.add(list);

        }
        return result;
    }


    public static void main(String[] args) {

        //构建二叉树
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        node1.left = node2;
        node1.right = node3;


        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node3.left = node4;
        node3.right = node5;

        TreeNode node6 = new TreeNode(60);
        TreeNode node7 = new TreeNode(70);
        node2.left = node6;
        node2.right = node7;

        System.out.println(levelOrder(node1));

    }

}
