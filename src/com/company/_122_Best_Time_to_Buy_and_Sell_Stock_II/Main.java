package com.company._122_Best_Time_to_Buy_and_Sell_Stock_II;

public class Main {
    public static void main(String[] args) {
        int[] prices = {7,3,5,1,6,4};
        Solution solution = new Solution();
        System.out.println(solution.greedy_MaxProfit(prices));
    }

}

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int tmpProfit = 0;
        int buy = 0;
        int sell = 1;

        while (buy <= sell && sell < prices.length) {
            if (prices[sell] < prices[buy] && tmpProfit <= 0) {
                ++sell;
                ++buy;
            } else if (prices[sell] < prices[buy] && tmpProfit > 0) {
                buy = sell;
                sell = buy+1;
                maxProfit += tmpProfit;
                tmpProfit = 0;
            } else if (prices[sell] >= prices[buy]) {
                if (prices[sell]-prices[buy] > tmpProfit) {
                    tmpProfit = prices[sell] - prices[buy];
                    sell++;
                } else {
                    buy = sell;
                    sell += 1;
                    maxProfit += tmpProfit;
                    tmpProfit = 0;
                }
            }
        }

        maxProfit += tmpProfit;

        return maxProfit;
    }

    public int dp_MaxProfit(int[] prices) {
        /**dp[i][0]代表第i天结束后手里没有股票的最大利益
        *dp[i][1]代表第i天结束后手里有股票的最大利益

        *状态转移方程
        *手里没有股票时最大利益有两种情况，前一天手里也没有股票；前一天把股票卖了
        *dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
        *手里有股票是最大利益有两种情况，前一天手里没有股票，今天购入；前一天手里有股票
        *dp[i][1] = Math.max(dp[i-1][0]-prices[i], dp[i-1][1]);

        *此时最大的收益为dp[n-1][0],n为数组长度

        *由题意知
        *dp[0][0] = 0;
        *dp[0][1] = -prices[0];
         */

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; ++i) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][0]-prices[i], dp[i-1][1]);
        }

        return dp[prices.length-1][0];


    }

    public int greedy_MaxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; ++i) {
            ans += Math.max(0, prices[i]-prices[i-1]);
        }
        return ans;
    }
}
