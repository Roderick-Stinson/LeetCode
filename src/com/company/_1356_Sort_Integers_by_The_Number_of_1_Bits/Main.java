package com.company._1356_Sort_Integers_by_The_Number_of_1_Bits;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1111,7644,1107,6978,8742,1,7403,7694,9193,4401,377,8641,5311,624,3554,6631};
        int[] ans = solution.sortByBits(arr);
        System.out.println(Arrays.toString(ans));
    }
}

class Solution {
    public int[] sortByBits(int[] arr) {
        int[][] map = new int[arr.length][2];
        for (int i = 0; i < arr.length; ++i) {
            map[i][0] = arr[i];
            map[i][1] = getOneFromBinary(arr[i]);
        }

        sort(map);

        for (int i = 0; i < arr.length; ++i) {
            arr[i] = map[i][0];
        }
        return arr;

    }

    public int getOneFromBinary(int num) {
        int sumOne = 0;
        //得到二进制数
        String s = Integer.toBinaryString(num);
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1')
                ++sumOne;
        }
        return sumOne;
    }

    public void sort(int[][] map) {

        for (int i = 1; i < map.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;

            for (int j = 0; j < map.length - i; j++) {
                if (map[j][1] > map[j+1][1] || (map[j][1] == map[j+1][1] && map[j][0] > map[j+1][0])) {
                    int tmp0 = map[j][0];
                    int tmp1 = map[j][1];
                    map[j][0] = map[j + 1][0];
                    map[j][1] = map[j + 1][1];
                    map[j + 1][0] = tmp0;
                    map[j+1][1] = tmp1;

                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
    }


}
