package LeetCode;

/**
 * Created by hongjiayong on 2017/4/9.
 * For LeetCode @2 Add Two Numbers
 */
public class LeetCodeAddTwoNumbers_2 {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    private static void addNext(ListNode cur, ListNode res){
        while(res.next != null){
            res = res.next;
        }

        res.next = cur;
    }

    private static ListNode getLastNode(ListNode res){
        while(res.next != null){
            res = res.next;
        }
        return res;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){

//        int l1_count = 0;
//        int l2_count = 0;
//        ListNode l1_temp = l1;
//        ListNode l2_temp = l2;
//        while (l1_temp.next != null){
//            l1_count ++;
//            l1_temp = l1_temp.next;
//        }
//
//        while (l2_temp.next != null){
//            l2_count ++;
//            l2_temp = l2_temp.next;
//        }
//
//        if (l1_count < l2_count){
//            l2_temp = l2;
//            l2 = l1;
//            l1 = l2_temp;
//        }

        ListNode res = new ListNode(0);
        int flag = 0;
        while (l1 != null){
            ListNode cur = getLastNode(res);
            int temp = l1.val + cur.val;
            if (l2 != null){
                temp += l2.val;
                l2 = l2.next;
            }

            cur.val = temp % 10;
            flag += temp / 10;
            if (l1.next != null || flag != 0 || l2 != null) {
                addNext(new ListNode(flag), res);
            }
            flag = 0;

            l1 = l1.next;
        }

        while (l2 != null){
            ListNode cur = getLastNode(res);
            int temp = l2.val + cur.val;
            cur.val = temp % 10;
            flag += temp / 10;
            if (l2.next != null || flag != 0) {
                addNext(new ListNode(flag), res);
            }
            flag = 0;

            l2 = l2.next;
        }

        return res;
    }

    public static void main(String [] args){
        ListNode l1_1 = new ListNode(0);
//        ListNode l1_2 = new ListNode(4);
//        ListNode l1_3 = new ListNode(3);
        ListNode l1 = l1_1;
//        l1.next = l1_2;
//        l1.next.next = l1_3;
        ListNode l2_1 = new ListNode(7);
        ListNode l2_2 = new ListNode(3);
//        ListNode l2_3 = new ListNode(4);
        ListNode l2 = l2_1;
        l2.next = l2_2;
//        l2.next.next = l2_3;
        ListNode res = addTwoNumbers(l1, l2);

        while (res.next != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
