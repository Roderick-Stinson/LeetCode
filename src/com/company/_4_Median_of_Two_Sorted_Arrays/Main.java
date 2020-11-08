package com.company._4_Median_of_Two_Sorted_Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Solution s = new Solution();
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{0};
        System.out.println(s.findMedianSortedArrays(nums1,nums2));
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sortedarr = new int[nums1.length + nums2.length];//存放两个数字整合起来
        int i = 0, j = 0;
        int counter = 0;
        int length = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) { sortedarr[counter++] = nums1[i++]; }
            else { sortedarr[counter++] = nums2[j++]; }
        }
        if (i < nums1.length && j == nums2.length) {
            for (; i < nums1.length; ) { sortedarr[counter++] = nums1[i++]; }
        } else if (i == nums1.length && j < nums2.length) {
            for (; j < nums2.length; ) { sortedarr[counter++] = nums2[j++]; }
        }
        length = sortedarr.length;
        if (length%2 == 0) { return (((double)sortedarr[length/2] + (double)sortedarr[length/2 - 1]) / 2); }
        else { return sortedarr[length/2]; }
    }
}
