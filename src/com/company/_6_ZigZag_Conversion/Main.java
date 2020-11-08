package com.company._6_ZigZag_Conversion;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        String ans = solution.convert("", 1);
        System.out.println(ans);
    }
}
class Solution {
    public String convert(String s, int numRows) {
        int interval = 2*numRows-2;//每组字符的个数
        if (interval == 0) { return s; }//若输入为""，则直接返回
        int counter = 0;
        char[][] str = new char[numRows][2*s.length()/numRows+1];
        char[] ans = new char[s.length()];
        //设每interval个数为一组，每组的特征为：每组的第一个字符最先输出
        //
        // 如 Input：PAYPALISHIRING， numRows = 4
        // P     I     N
        // A   L S   I G
        // Y A   H R
        // P     I
        //
        // PAYPAL为第一组，ISHIRI为第二组，NG为第三组
        //
        // ，
        for (int j = 0; j < s.length()/interval+1; ++j) {//表示第j组
            for (int i = 0; i < interval && i+j*interval < s.length(); ++i) {//表示一组内的第i个数
                if (i < numRows) {
                    str[i][2*j] = s.charAt(i+j*interval);
                } else {
                    str[interval - i][2*j+1] = s.charAt(i+j*interval);
                }
            }
        }

        //将str数组转化为要求类型数组ans
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < 2*s.length()/interval+1; ++j) {
                if (str[i][j] != 0) { ans[counter++] = str[i][j]; }
            }
        }

        return new String(ans);
    }
}