package linkedlist.reorder_list_143;

import linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：rqxiao
 * @description：TODO
 * @date ：2020/10/20 11:02
 * <p>
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        if (head == null) {
            return;
        }

        ListNode listNode = head;
        while (listNode != null) {
            list.add(listNode);
            listNode = listNode.next;
        }

        ListNode resultNode = null;

        ListNode lastNode = null;

        int i = 0;
        int j = list.size() - 1;

        while (i <= j) {

            ListNode listNode1 = list.get(i);

            if (resultNode == null) {
                resultNode = listNode1;
                lastNode = resultNode;
            } else {
                lastNode.next = listNode1;
                lastNode = listNode1;
            }


            if (i != j) {
                ListNode listNode2 = list.get(j);
                lastNode.next = listNode2;
                lastNode = listNode2;
            }

            i++;
            j--;
        }
        lastNode.next = null;

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
        solution.reorderList(l1);
    }
}