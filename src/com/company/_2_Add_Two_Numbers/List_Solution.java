package com.company._2_Add_Two_Numbers;

public class List_Solution {
    public static void main(String[] args) {
        // write your code here
        ListNode a3 = new ListNode(9);
//        ListNode a2 = new ListNode(4,a3);
//        ListNode a1 = new ListNode(2,a2);


        ListNode b10 = new ListNode(9);
        ListNode b9 = new ListNode(9,b10);
        ListNode b8 = new ListNode(9,b9);
        ListNode b7 = new ListNode(9,b8);
        ListNode b6 = new ListNode(9,b7);
        ListNode b5 = new ListNode(9,b6);
        ListNode b4 = new ListNode(9,b5);
        ListNode b3 = new ListNode(9,b4);
        ListNode b2 = new ListNode(9,b3);
        ListNode b1 = new ListNode(1,b2);

        List_Solve ls = new List_Solve();
        ListNode ans = ls.addTwoNumbers(a3, b1);
        while (ans.next != null) {
            System.out.print(ans.val);
        }

    }
}

class List_Solve {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode temporaryPointer = ans;
        ListNode next = null;
        ListNode temporaryPointer_l1 = l1, temporaryPointer_l2 = l2;
        int additionCarry = 0;//加法进位

        while (temporaryPointer_l1 != null || temporaryPointer_l2 != null) {
            next = new ListNode();
            if (temporaryPointer_l1 != null && temporaryPointer_l2 != null) {//两个链表长度相等部分
                temporaryPointer.val = temporaryPointer_l1.val + temporaryPointer_l2.val + additionCarry;
                if (temporaryPointer.val > 9) {
                    additionCarry = temporaryPointer.val / 10;
                    temporaryPointer.val %= 10;
                } else {additionCarry = 0;}
                temporaryPointer_l1 = temporaryPointer_l1.next;
                temporaryPointer_l2 = temporaryPointer_l2.next;

            } else if (temporaryPointer_l1 != null && temporaryPointer_l2 == null) {//l1链有剩余
                temporaryPointer.val = temporaryPointer_l1.val + additionCarry;
                if (temporaryPointer.val > 9) {
                    additionCarry = temporaryPointer.val / 10;
                    temporaryPointer.val %= 10;
                } else {additionCarry = 0;}
                temporaryPointer_l1 = temporaryPointer_l1.next;

            } else if (temporaryPointer_l2 != null && temporaryPointer_l1 == null) {//l2链还有剩余
                temporaryPointer.val = temporaryPointer_l2.val + additionCarry;
                if (temporaryPointer.val > 9) {
                    additionCarry = temporaryPointer.val / 10;
                    temporaryPointer.val %= 10;
                } else {additionCarry = 0;}
                temporaryPointer_l2 = temporaryPointer_l2.next;
            }
            if (temporaryPointer_l1 != null || temporaryPointer_l2 != null) {

                temporaryPointer.next = next;
                temporaryPointer = next;
            }
        }
        if (additionCarry > 0) {
            next = new ListNode(additionCarry);
            temporaryPointer.next = next;
        }
        return ans;

    }

}