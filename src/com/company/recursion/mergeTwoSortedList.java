package com.company.recursion;

/**
 * Created by Lindaliu on 2020-06-29.
 */
public class mergeTwoSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 ==null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode node =new ListNode();
        if (l1.val <= l2.val) {
            node.val = l1.val;
            node.next = mergeTwoLists(l1.next, l2);
        } else {
            node.val = l2.val;
            node.next = mergeTwoLists(l1, l2.next);
        }
        return node;
    }
}
