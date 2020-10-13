package linkedlist.swap_nodes_in_pairs_24;

import linkedlist.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {

        ListNode result = head;

        ListNode last = null;

        while (head != null && head.next != null) {

            ListNode first = head;
            ListNode second = head.next;
            ListNode nextnext = head.next.next;

            first.next = nextnext;
            second.next = first;

            if (last == null) {
                result = second;
                last = result.next;
            } else {
                last.next = second;
                last = last.next.next;
            }
            head = nextnext;
        }
        return result;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;


        Solution solution = new Solution();
        ListNode listNode = solution.swapPairs(l1);

    }
}
