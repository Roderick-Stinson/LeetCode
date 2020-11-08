package com.company._7_Reverse_Integer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        System.out.println(solution.reverse_1(-2147483648));
    }
}

class Solution {
    public int reverse(int x) {
        String integer = String.valueOf(x);
        boolean isPositive = true;
        int ans = 0;
        if (x == -2147483648) {
            return 0;
        } else if (x < 0) {
            isPositive = false;
            x = -x;
        }
        String reverse = "";
        do {
            reverse += x%10;
            x /= 10;
        } while (x != 0);
        try {
            ans = Integer.parseInt(reverse);
        } catch (Exception e) {
            ans = 0;
        }
        if (!isPositive) { ans = -ans; }
        return ans;
    }
    public int reverse_1(int x) {
        int pop = 0, rev = 0;

        while (x != 0) {
            pop = x%10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || rev == Integer.MAX_VALUE && pop > 7) { return 0; }
            if (rev < Integer.MIN_VALUE/10 || rev == Integer.MIN_VALUE && pop < -8) { return 0; }
            rev = rev*10+pop;
        }
        return rev;
    }
}