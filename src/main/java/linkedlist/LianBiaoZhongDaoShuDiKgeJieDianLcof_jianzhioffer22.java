package linkedlist;

/**
 * @Author: rqxiao
 * @Date: 2020-9-29 15:50
 * @Description: 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * 通过次数78,791提交次数99,946
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LianBiaoZhongDaoShuDiKgeJieDianLcof_jianzhioffer22 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode getKthFromEnd(ListNode head, int k) {


        ListNode former = head;
        ListNode latter = head;


        for (int i = 0; i < k - 1; i++) {
            former = former.next;
        }


        while (former.next != null) {

            former = former.next;
            latter = latter.next;

        }


        return latter;

    }


    public static void main(String[] args) {


        LianBiaoZhongDaoShuDiKgeJieDianLcof_jianzhioffer22 l = new LianBiaoZhongDaoShuDiKgeJieDianLcof_jianzhioffer22();
        ListNode n1 = l.new ListNode(1);
        ListNode n2 = l.new ListNode(2);
        n1.next = n2;
        ListNode n3 = l.new ListNode(3);
        n2.next = n3;

        ListNode n4 = l.new ListNode(4);
        n3.next = n4;

        ListNode n5 = l.new ListNode(5);
        n4.next = n5;

        ListNode listNode = l.getKthFromEnd(n1, 2);


    }


}
