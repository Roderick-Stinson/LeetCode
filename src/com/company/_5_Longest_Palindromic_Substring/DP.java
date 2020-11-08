package com.company._5_Longest_Palindromic_Substring;


public class DP {
    public String longestPalindrome(String s) {
        String ans = new String();//存放答案
        int length = s.length();//存放字符串的长度
        int[][] dp = new int[length][length];


        for (int counter = 0; counter < length; ++counter) {//counter存放两个边界间的距离，即子串的长度-1
            for (int i = 0; i + counter < length; ++i) {//左边界
                int j = i + counter;//右边界
                //判断条件
                if (counter == 0) {//一个字符也是回文，如a
                    dp[i][j] = 1;
                } else if (counter == 1) {//两个字符的回文，如aa
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 1;
                    }
                } else {
                    //状态转移方程
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] == 1 && ans.length() < j - i + 1) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }
}

