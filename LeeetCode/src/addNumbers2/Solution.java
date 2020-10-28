package addNumbers2;



import util.ListNode;

import java.util.Stack;

public class Solution {


    static class ReverseList {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode reversed1 = reverse(l1);
            ListNode reversed2 = reverse(l2);
            ListNode ansReversed = add(reversed1, reversed2);
            return reverse(ansReversed);
        }

        private ListNode add(ListNode l1, ListNode l2) {
            int toAdd = 0;


            ListNode head = new ListNode(-1);
            ListNode curr = head;

            while (l1 != null || l2 != null) {
                int sum = toAdd;
                if (l1 != null && l2 != null) {
                    sum += l1.val + l2.val;
                } else if (l1 != null) {
                    sum += l1.val;
                } else sum += l2.val;

                if (sum >= 10) {
                    toAdd = 1;
                    sum = sum % 10;
                } else toAdd = 0;

                curr.next = new ListNode(sum);
                curr = curr.next;

                l1 = l1 != null ? l1.next : null;
                l2 = l2 != null ? l2.next : null;
            }

            if (toAdd > 0) curr.next = new ListNode(1);

            return head.next;
        }

        private ListNode reverse(ListNode head) {
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

    static class StackSolution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> l1Stack = new Stack<>();
            Stack<Integer> l2SStack = new Stack<>();

            ListNode n1 = l1;
            ListNode n2 = l2;

            while (n1 != null) {
                l1Stack.push(n1.val);
                n1 = n1.next;
            }

            while (n2 != null) {
                l2SStack.push(n2.val);
                n2 = n2.next;
            }

            Stack<Integer> res = add(l1Stack, l2SStack);

            ListNode head = new ListNode(res.pop());
            ListNode result = head;
            while (!res.isEmpty()) {
                result.next = new ListNode(res.pop());
                result = result.next;
            }
            return head;
        }

        private Stack<Integer> add(Stack<Integer> l1Stack, Stack<Integer> l2SStack) {
            int toAdd = 0;


            Stack<Integer> ret = new Stack<>();

            while (!l1Stack.isEmpty() || !l2SStack.isEmpty()) {
                int sum = toAdd;
                if (!l1Stack.isEmpty() && !l2SStack.isEmpty()) {
                    sum += l1Stack.pop() + l2SStack.pop();
                } else if (!l1Stack.isEmpty()) {
                    sum += l1Stack.pop();
                } else sum += l2SStack.pop();

                if (sum >= 10) {
                    toAdd = 1;
                    sum = sum % 10;
                } else toAdd = 0;

                ret.push(sum);
            }

            if (toAdd > 0) ret.push(1);

            return ret;
        }

        public static void main(String[] args) {
            StackSolution stackSolution = new StackSolution();
            ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
            ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

            stackSolution.addTwoNumbers(l1, l2);
        }
    }


}
