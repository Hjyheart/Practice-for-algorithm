package src;

import java.util.List;

/**
 * Created by I332329 on 11/24/2017.
 */
public class LeetCode147_InsertionSortList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        ListNode current = head;
        while(current!= null) {
            pre = helper;
            while(pre.next != null && pre.next.val < current.val) {
                pre = pre.next;
            }
            ListNode next = current.next;
            current.next = pre.next;
            pre.next = current;
            current = next;
        }
        return helper.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(3);
        ListNode two = new ListNode(1);
        ListNode three = new ListNode(2);
        one.next = two;
        two.next = three;
        three.next = null;
        insertionSortList(one);
    }
}
