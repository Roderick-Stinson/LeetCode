package com.company._9_Palindrome_Number;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(0));
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);//转成字符串
        String s_rev = new StringBuffer(s).reverse().toString();//字符串取反
        if (s.equals(s_rev)) return true;
        else return false;
    }
}