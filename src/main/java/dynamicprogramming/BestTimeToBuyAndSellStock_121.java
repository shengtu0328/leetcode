package dynamicprogramming;

/**
 * @Author: rqxiao
 * @Date: 2020-7-10 15:03
 * @Description:
 *121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 */
public class BestTimeToBuyAndSellStock_121 {


    public static int maxProfit(int[] prices) {
        // 首先定义一个最低谷
        int min = Integer.MAX_VALUE;
        // 首先结果
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            // 更新最低谷
            min = Math.min(min, prices[i]);
            if ((prices[i] - min) - result > 0) {
                // 更新结果
                result = (prices[i] - min);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] a=new int[]{7,1,5,3,6,4};
        System.out.println(BestTimeToBuyAndSellStock_121.maxProfit(a));
    }
}
