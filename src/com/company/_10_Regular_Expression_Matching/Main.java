package com.company._10_Regular_Expression_Matching;

import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String p = new String("mis*is*p*.");
        String s = new String("mississippi");
        Solution solution = new Solution();
        System.out.println(solution.isMatch(s, p));
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        //将给定字符串转为数组
        char[] sarr = s.toCharArray();
        char[] parr = p.toCharArray();

        //创建双指针
        int sPointer = 0, pPointer = 0;

        boolean ismatch = true;

        //".*"代表任何字符串
        if (p.equals(".*")) return true;

        //主要思路：将s串化为带*的形式，将p串的.化为确定字符
        //转化完成后判断s是否为p的子串
        //若是，则返回true；若不是，则返回false

        while (sPointer < s.length() && pPointer < p.length()){//遍历s串和p串，做相应改变
            if (parr[pPointer] == sarr[sPointer]){
                ++pPointer;
                ++sPointer;

            } else if (parr[pPointer] == '*') {
                if (parr[pPointer-1] == sarr[sPointer] && pPointer > 0) {
                    sarr[sPointer] = '*';
                    ++sPointer;
                } else if (parr[pPointer+1] == sarr[sPointer] && pPointer+1 < p.length()) {
                    ++pPointer;
                } else {//*字符前后都失配
                    if (sPointer+1 < s.length())
                        ++sPointer;
                    ++pPointer;
                }
            } else if (parr[pPointer] == '.') {
                parr[pPointer] = sarr[sPointer];
                ++pPointer;
                ++sPointer;
            }
            else {//失配
                ++sPointer;
                ++pPointer;
            }
        }

        //将两个char数组转为字符串
        p = new String(parr);
        s = new String(sarr);



        return ismatch;

    }
}

enum Result {
    TRUE, FALSE
}

class Solution_1 {
    Result[][] memo;

    public boolean isMatch(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) ||
                        first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}