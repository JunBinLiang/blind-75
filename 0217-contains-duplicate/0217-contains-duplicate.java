// Study Java Stream with Blind75 217.Contains Duplicate
class Solution {
    public boolean containsDuplicate(int[] nums) {
       // Set<Integer> s = new HashSet<>();
       // return Arrays.stream(nums).filter(x -> s.add(x)).count() != nums.length;
        return Arrays.stream(nums).distinct().count() != nums.length;
    }
}