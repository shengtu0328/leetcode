package linkedlist;

/**
 * @Auther: rqxiao
 * @Date: 2019-7-2 10:12
 * @Description:
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *

 *
 *
 */
public  class ReverseLinkedList_206 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    //首先，肯定知道最后返回的结果是输入链表的链表尾节点。
    // 但先找到尾节点是很难继续实现的，因为链表没有办法高效获取前驱。
    // 往往这类问题很多时候都要想到建立一个新的节点，之后在遍历输入的时候重新组织节点顺序，将节点挂在新节点上。
    // 所以高效的做法是在遍历链表的过程中，一个一个的把输入链表的节点放到一个新的链表头部。所以思路就是建立一个新的链表头，每次遍历输入链表的节点都把他放到新链表的头部，这样遍历完成后就获得了反转的链表。详细代码注释见下。
    // *  result 结果        first  每次新的挂载节点
    // *  1                 1
    // *  2 1               2
    // *  3 2 1             3
    // *  4 3 2 1           4
    // *  5 4 3 2 1         5
    public static ListNode reverseList(ListNode head) {
        ListNode first = head;
        ListNode result = null; //建立一个新的节点用来存放结果
        while (first != null) { //遍历输入链表，开始处理每一个节点

            ListNode second = first.next;

            first.next=result;
            result=first;

            first=second;

        }
        return result;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);

        ListNode l2 = new ListNode(2);

        ListNode l3 = new ListNode(3);

        ListNode l4 = new ListNode(4);

        ListNode l5 = new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;

        ListNode listNode = ReverseLinkedList_206.reverseList(l1);
        System.out.println(listNode);

    }
}
