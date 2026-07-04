/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode fast = head;

        while(n>0){
            fast = fast.next;
            n--;
        }
        if(fast == null)return head.next;
        while(fast.next!=null){
            curr = curr.next;
            fast = fast.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}