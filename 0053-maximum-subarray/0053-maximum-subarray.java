// Study Java Stream with Blind75 53.Maximum Subarray
class Solution {
    public int maxSubArray(int[] nums) {
         return IntStream.range(0, nums.length).map(i -> i == 0 ? nums[0] : (nums[i] += Math.max(0, nums[i - 1]))).max().getAsInt();
    }
}