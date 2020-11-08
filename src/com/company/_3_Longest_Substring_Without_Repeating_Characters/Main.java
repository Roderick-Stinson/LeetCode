package com.company._3_Longest_Substring_Without_Repeating_Characters;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution s = new Solution();
        String t = new String("abba");
        System.out.println(s.lengthOfLongestSubstring(t));
    }
}


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charset = new int[256];//charset中存放字符出现时的下标
        int maxlength = 0, whenLastTimeIndex = 0;//whenLastTimeIndex的值为该字符上一次出现时的下

        for (int b = 0; b < s.length(); ++b) {
            if (charset[s.charAt(b)] > 0 && charset[s.charAt(b)] > whenLastTimeIndex) {//之前出现过
                maxlength = Math.max(maxlength, b-whenLastTimeIndex);
                whenLastTimeIndex = charset[s.charAt(b)];//a指针指向曾经出现过得位置的下一个
            }
            charset[s.charAt(b)] = b+1;
        }
        return Math.max(maxlength,s.length() - whenLastTimeIndex);
    }
}