package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: rqxiao
 * @Date: 2020-9-28 13:23
 * @Description: 给定一个二叉树
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


public class PopulatingNextRightPointersInEachNodeii_117 {


    public Queue<Node> queue = new LinkedList<>();

    public Node connect(Node root) {

        queue.offer(root);


        bfs();
        return root;
    }


    public void bfs() {

        while (queue.size() > 0) {


            Node last = null;

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Node poll = queue.poll();


                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }


                if (last != null) {
                    last.next = poll;
                }
                last = poll;
            }


        }

    }


    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNodeii_117 p = new PopulatingNextRightPointersInEachNodeii_117();


        Node n1 = new Node(1);


        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.left = n2;
        n1.right = n3;


        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n2.left = n4;
        n2.right = n5;

        Node n7 = new Node(7);


        n3.right = n7;


        Node result = p.connect(n1);


    }

}
