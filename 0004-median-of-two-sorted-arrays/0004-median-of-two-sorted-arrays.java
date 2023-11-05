class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return IntStream.concat(IntStream.of(nums1), IntStream.of(nums2)).sorted().skip((nums1.length + nums2.length - 1) / 2).limit(2 - (nums1.length + nums2.length) % 2).average().getAsDouble();
    }
}