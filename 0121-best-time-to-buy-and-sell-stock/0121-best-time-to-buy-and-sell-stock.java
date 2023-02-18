// Study Java Stream with Blind75 121. Best Time to Buy and Sell Stock
class Solution {
    public int maxProfit(int[] nums) {
        return IntStream.range(0, nums.length).map(i -> i == 0 ? 0 : Math.max(nums[i] - nums[i - 1], Math.max(0, -(nums[i] = Math.min(nums[i], nums[i - 1]))))).max().getAsInt();
    }
}