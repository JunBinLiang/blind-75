// Study Java Stream with Blind75 300.Longest Increasing Subsequence
class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        return IntStream.range(0, nums.length).map(i -> dp[i] = (i == 0 ? 1 : IntStream.range(0, i).map(j -> 1 + (nums[i] > nums[j] ? dp[j] : 0)).max().getAsInt())).max().getAsInt();
    }
}