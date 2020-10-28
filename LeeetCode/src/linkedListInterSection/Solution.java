package linkedListInterSection;

import util.ListNode;

public class Solution {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode iterA = headA;
        ListNode iterB = headB;

        int sizeA = 0;
        int sizeB = 0;

        while (iterA != null) {
            sizeA++;
            iterA = iterA.next;
        }

        while (iterB != null) {
            sizeB++;
            iterB = iterB.next;
        }

        iterA = headA;
        iterB = headB;
        while (sizeA > sizeB) {
            if (iterB == iterA) return iterA;
            iterA = iterA.next;
            sizeA--;
        }
        while (sizeB > sizeA) {
            if (iterB == iterA) return iterA;
            iterB = iterB.next;
            sizeB--;
        }

        while (sizeA > 0 && iterB != iterA) {
            if (iterB == iterA) return iterA;
            iterA = iterA.next;
            iterB = iterB.next;
            sizeA--;
        }

        return iterA;
    }
}
