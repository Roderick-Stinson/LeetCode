package com.company._8_String_to_Integer;

import java.security.spec.ECField;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
//	// write your code here
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("+-2"));

    }
}

class Solution {
    public int myAtoi(String s) {
        boolean isPositive = true;
        int ans = 0;

        s = s.trim();//取出s前后的空格
        if (s.length() < 1) return 0;//必须放在这，防止空串情况s.charAt函数抛异常
        if (s.charAt(0) < '0' && s.charAt(0) != '-' && s.charAt(0) != '+' || s.charAt(0) > '9') { return 0; }//s的第一个非空格字符不是数的情况

        for (int i = 1; i < s.length(); ++i) {//未遍历字符串第一个字符，防止其为负号
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') continue;
            else s = s.substring(0, i);//发现第一个非数字字符时，返回数字部分的子串，
        }
        if (s.equals("-") || s.equals("+")) return 0;//必须放在这，防止类似"+-2"的情况发生
        if (s.charAt(0) == '-') {
            isPositive = false;
        }
        try {
            ans = Integer.parseInt(s);
        } catch (Exception e) {//越界
            if (isPositive) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }
        return ans;
    }
}