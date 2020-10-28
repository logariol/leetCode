package addTwoNumbers;

import util.ListNode;

/**
 * Add tow numbers problem.
 * Time complexity: O(max(m,n)) where m, n are sizes of l1 and l2
 * Space complexity: O(max(m,n)) where m, n are sizes of l1 and l2
 */
public class CarrySum {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        //  (2 -> 4 -> 3) + (5 -> 6 -> 4)

        ListNode head = new ListNode();
        ListNode curr = head;

        int carry = 0, val;

        while (l2 != null || l1 != null) {
            if (l1 == null) {
                val = l2.val + carry;
            } else if (l2 == null) {
                val = l1.val + carry;
            } else {
                val = l1.val + l2.val + carry;
            }

            if (val >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }

            curr.next = new ListNode(val % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry == 1) {
            curr.next = new ListNode(carry);
        }
        return head.next;


    }
}
