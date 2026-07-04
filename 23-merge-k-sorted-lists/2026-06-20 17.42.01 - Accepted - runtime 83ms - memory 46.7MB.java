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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;

        for (ListNode list : lists) {
            result = merge(result, list);
        }
        return result;
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if(list2 == null){
            return list1;
        }

        ListNode curr = (list1.val <= list2.val ? list1 : list2);
        ListNode head = curr;

        if (curr == list1) {
            list1 = list1.next;
        } else {
            list2 = list2.next;
        }
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = list1 == null ? list2 : list1;
        return head;
    }
}