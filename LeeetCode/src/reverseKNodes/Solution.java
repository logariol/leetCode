package reverseKNodes;

import util.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode start = head;
        ListNode preStart = null, postEnd = null;

        while (start != null) {
            int cnt = k;
            while (cnt > 1) {
                curr = curr.next;
                cnt--;
            }
            if (curr == null) return head;
            postEnd = curr.next;

            reverse(start, curr);
            curr.next = postEnd;

            if (preStart != null) preStart.next = start;
            preStart = curr;
            start = start.next;
        }
        return head;
    }

    private void reverse(ListNode start, ListNode curr) {
        ListNode prev = null;
        while (start != curr.next) {
            ListNode next = start.next;

            start.next = prev;
            prev = start;
            start = next;
        }
    }

    public static void main(String[] args) {

    }
}
