// Study Java Stream with Blind75 1.Two Sum
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();
        return new int[]{
            IntStream.range(0, nums.length).map(i -> i).filter(i -> s1.contains(target - nums[i]) ? true : s1.add(nums[i]) & false).findFirst().getAsInt(),
            IntStream.range(0, nums.length).map(i -> nums.length - i - 1).filter(i -> s2.contains(target - nums[i]) ? true : s2.add(nums[i]) & false).findFirst().getAsInt()
        };
    }
}