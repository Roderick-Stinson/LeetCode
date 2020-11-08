package com.company._327_Count_of_Range_Sum;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-2147483647,0,-2147483647,2147483647};
        int lower = -564;
        int upper = 3864;
        Solution solution = new Solution();
        System.out.println(solution.countRangeSum(nums, lower, upper));
    }
}

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = 0;
        //dp解法
        //只需要记录上一状态而不需要记录所有状态
        long dp = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i; j < nums.length; ++j) {
                dp = i==j?nums[i]:dp+nums[j];
                if (dp <= upper && dp >= lower)
                    ++n;
            }
        }
        return n;
    }

}
