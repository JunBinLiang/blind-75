// Study Java Stream with Blind75 78.Subsets
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return IntStream.range(0, 1 << nums.length).mapToObj(s -> IntStream.range(0, nums.length).filter(i -> (s & (1 << i)) > 0).mapToObj(i -> nums[i]).collect(Collectors.toList())
        ).collect(Collectors.toList());
    }
}