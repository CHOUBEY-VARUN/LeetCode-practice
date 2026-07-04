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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        insertNode(head);
        return head;
    }

    public void insertNode(ListNode node){
        if(node.next == null) return;
        ListNode nextNode = node.next;
        int GCD = gcd(node.val,nextNode.val);
        ListNode temp = new ListNode(GCD);
        node.next = temp;
        temp.next = nextNode;
        insertNode(nextNode);
    }

    public int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}
}