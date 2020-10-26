package com.company.recursion;

/**
 * Created by Lindaliu on 2020-10-25.
 */
import java.util.*;
public class MergekSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        // Nlog(K)
        // dummy node
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        // min heap

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a1,a2) -> a1.val-a2.val);
        for (ListNode list: lists) {
            if (list!=null) {
                pq.add(list);
            }
        }

        while(!pq.isEmpty()) {
            // add to result
            ListNode cur = pq.poll();
            res.next = new ListNode(cur.val);
            res = res.next;
            if (cur.next!=null) {
                pq.add(cur.next);
            }
        }
        return dummy.next;
    }

    public ListNode mergeKLists_brute_force(ListNode[] lists) {
        ListNode res = null;
        for (ListNode list: lists) {
            res = mergeTwoLists(res, list);
        }
        return res;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

}
