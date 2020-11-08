package com.company._19_Remove_Nth_Node_From_End_of_List;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //双指针法
        ListNode first = head, second = head;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        if (first == null) {
            return head.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }
    public ListNode recurisive_RemoveNthFromEnd(ListNode head, int n) {
        //递归解法
        int pos = length(head, n);
        if (pos == n) //pos为删除的是倒数第n个节点
            return head.next;
        return head;
    }

    public ListNode stack_RemoveNthFromEnd(ListNode head, int n) {
        //栈解法
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        if (stack.isEmpty())
            return head.next;
        ListNode tmp = stack.pop();
        tmp.next = tmp.next.next;
        return head;
    }


    public int length(ListNode head, int n) {
        if (head == null)
            return 0;
        int pos = length(head.next, n)+1;
        if (pos == n+1)
            head.next = head.next.next;
        return pos;
    }


}