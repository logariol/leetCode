package sortList;

import util.ListNode;

public class Solution {


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);

    }

    ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
                curr = curr.next;
            } else {
                curr.next = right;
                right = right.next;
                curr = curr.next;
            }
        }
        curr.next = (left != null) ? left : right;
        return head.next;
    }

    public static void main(String[] args) {
        System.out.println(Math.ceil(0.3));
    }
}
