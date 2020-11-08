package com.company._5_Longest_Palindromic_Substring;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String s = new String("abcdcdd");
//        Solution solution = new Solution();
//        System.out.println(solution.longestPalindrome(s));

//        RecursiveSolution recursiveSolution = new RecursiveSolution();
//        System.out.println(recursiveSolution.longestPalindrome(s));

        DP dp = new DP();
        Solution solution = new Solution();
        RecursiveSolution recursiveSolution = new RecursiveSolution();

        System.out.println("FROM DP: " + dp.longestPalindrome(s));
        System.out.println("FROM SOLUTION: " + solution.longestPalindrome(s));
        System.out.println("FROM RECURSIVESOLUTION: " + recursiveSolution.longestPalindrome(s));

    }
}

/**
 * 超时
 */
class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int length = s.length();
        String temporary = "";

        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= i; j--) {
                if (s.charAt(i) == s.charAt(j)) {//可能回文
                    temporary = ifPalindrome(s.substring(i, j + 1));
                }
                if (temporary.length() > ans.length()) {
                    ans = temporary;
                }
            }
        }

        return ans;

    }


    private String ifPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else return "";
        }
        return s;
    }
}


class RecursiveSolution {
    private int[] findminPalindrome(String s, int index) {
        //bb型判断
//        if (index < s.length()-1 && s.charAt(index) == s.charAt(index+1)) { return new int[]{index, index+1}; }
//        else
        if (index > 0 && s.charAt(index) == s.charAt(index - 1)) {
            return new int[]{index - 1, index};
        }
        //aba型判断
        if (index > 0 && index < s.length() - 1 && s.charAt(index - 1) == s.charAt(index + 1)) {
            return new int[]{index - 1, index + 1};
        } else return new int[]{0, 0};
    }

    public int[] findLongestPalindrome(String s, int[] index) {//根据找出来的最小回文，找出包含该最小回文的最大回文
        int[] index_Palindrome = index.clone();
        if (index[0] > 0 && index[1] < s.length() - 1 && s.charAt(index[0] - 1) == s.charAt(index[1] + 1)) {
            index[0]--;
            index[1]++;
            index_Palindrome = findLongestPalindrome(s, index);
        }
        if (index[0] > 0 && s.charAt(index[0] - 1) == s.charAt(index[0])) {
            index[0]--;
            index_Palindrome = findLongestPalindrome(s, index);
        } else if (index[1] < s.length() - 1 && s.charAt(index[1]) == s.charAt(index[1] + 1)) {
            index[1]++;
            index_Palindrome = findLongestPalindrome(s, index);
        }


        return index_Palindrome;

    }

    public String longestPalindrome(String s) {
        int[] ans = new int[]{0, 0};
        int[] index_Palindrome = new int[]{0, 0};
        if (s.length() == 0) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            index_Palindrome = findminPalindrome(s, i);//找到最小的回文
            if (index_Palindrome[1] != 0) {//存在最小回文,找包含该最小回文的最大回文
                index_Palindrome = findLongestPalindrome(s, index_Palindrome);
                i = index_Palindrome[1]-1;
            }
            if (index_Palindrome[1] - index_Palindrome[0] > ans[1] - ans[0]) {
                ans = index_Palindrome;
            }
        }
        return s.substring(ans[0], ans[1] + 1);
    }
}

