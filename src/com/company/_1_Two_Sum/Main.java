package com.company._1_Two_Sum;

public class Main {
    public static void main(String[] args) {
        int arr[] = {2,7,11,15};
        int target = 13;
        int[] ans = null;
        Solution solution = new Solution();
        ans = solution.twoSum(arr,target);
        if (ans == null) {
            System.out.println("ans = null");
        }
        for (int a:ans)
            System.out.println("answer is : " + a);
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target){
        for (int i=0;i<nums.length;++i){
            for (int j=i+1;j<nums.length;++j){
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return null;
    }
}
