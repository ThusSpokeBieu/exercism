import java.util.List;

class Knapsack {

    int maximumValue(int maximumWeight, List<Item> items) {
        int[] dp = new int[maximumWeight + 1];
        for (Item item : items) {
            for (int w = maximumWeight; w >= item.weight; w--) {
                dp[w] = Math.max(dp[w], dp[w - item.weight] + item.value);
            }
        }

        return dp[maximumWeight];
    }

}