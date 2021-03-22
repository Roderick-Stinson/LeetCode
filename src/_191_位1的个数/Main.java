package _191_位1的个数;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight();
    }
}

class Solution {
    public int hammingWeight(int n) {
        int counter = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                counter++;
            }
        }
        return counter;
    }
}
