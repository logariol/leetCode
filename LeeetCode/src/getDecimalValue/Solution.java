package getDecimalValue;

import util.ListNode;

public class Solution {
    public int getDecimalValue(ListNode head) {
        int pow = getSize(head) - 1;
        int result = 0;
        while (head != null) {
            result += Math.pow(2, pow--) * head.val;
            head = head.next;
        }
        return result;
    }

    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }
}
