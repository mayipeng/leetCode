/*
剑指 Offer 22. 链表中倒数第k个节点

输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。

示例：
给定一个链表: 1->2->3->4->5, 和 k = 2.
返回链表 4->5.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class twoPoint_linkedList_offer22 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        if(head==null)
            return null;

        for(int i=1; i<k; i++){
            if(fast.next!=null)
                fast = fast.next;
        }

        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode fast = head;
        while(fast!=null) {
            fast = fast.next;
            if(k==0) {
                head = head.next;
            }else {
                k--;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        ListNode a = getKthFromEnd(head, 3);
        while (a != null) {
            System.out.println("result: "+a.val);
            a = a.next;
        }

        // write your code here
    }

}
/*
python:
class Solution:
    def getKthFromEnd(self, head: ListNode, k: int) -> ListNode:
        fast = slow = head
        while k>0:
            fast = fast.next
            k-=1
        while fast != None:
            fast = fast.next
            slow = slow.next
        return slow
 */
