package mergeKSortedLists;

import util.ListNode;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        for (int i = 1; i < lists.length; i++) {
            lists[0] = merge(lists[0], lists[i]);
        }

        return lists[0];
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode preHead = new ListNode(-1);
        ListNode curr = preHead;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                curr.next = node1;
                node1 = node1.next;
            } else {
                curr.next = node2;
                node2 = node2.next;
            }
            curr = curr.next;
        }

        if (node1 == null) curr.next = node2;
        if (node2 == null) curr.next = node1;
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode l2 = new ListNode(2, new ListNode(3, new ListNode(4)));

        ListNode[] a = new ListNode[]{l1, l2};

        Solution s = new Solution();
        ListNode merge = s.mergeKLists(a);
        while (merge != null) {
            System.out.println(merge.val);
            merge = merge.next;
        }
    }
}
