package palindromeLinkedList;

import util.ListNode;

public class Solution {
    static class NewListSolution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) return true;
            ListNode newHead = new ListNode(head.val);
            ListNode copy = newHead;
            ListNode iter = head.next;

            while (iter != null) {
                copy.next = new ListNode(iter.val);
                copy = copy.next;
                iter = iter.next;
            }


            ListNode reversed = reverse(head);

            while (newHead != null) {
                if (reversed.val != newHead.val) return false;
                newHead = newHead.next;
                reversed = reversed.next;
            }

            return true;
        }

        ListNode reverse(ListNode head) {
            ListNode ans = new ListNode(-1);

            ListNode prev = null;

            while (head != null) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }

            return prev;
        }
    }

    static class NoExtraSpaceSolution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) return true;
            ListNode firstHalfEnd = getHalfEnd(head);
            ListNode reveresedSecondHalf = reverse(firstHalfEnd.next);

            ListNode p1 = head;
            ListNode p2 = reveresedSecondHalf;
            boolean result = true;
            while (result && p2 != null) {
                if (p1.val != p2.val) result = false;
                p1 = p1.next;
                p2 = p2.next;
            }


            firstHalfEnd.next = reverse(reveresedSecondHalf);
            return result;
        }

        private ListNode getHalfEnd(ListNode head) {
            ListNode first = head;
            ListNode second = head;

            while (second.next != null && second.next.next != null) {
                first = first.next;
                second = second.next.next;
            }

            return first;

        }


        ListNode reverse(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }
    }

}
