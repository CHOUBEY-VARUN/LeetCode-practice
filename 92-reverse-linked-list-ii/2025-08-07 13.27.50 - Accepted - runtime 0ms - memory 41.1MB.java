class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move prev to the node before the reversal starts
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // Start reversing
        ListNode start = prev.next;
        ListNode curr = start.next;

        for (int i = 0; i < right - left; i++) {
            start.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = start.next;
        }

        return dummy.next;
    }
}
