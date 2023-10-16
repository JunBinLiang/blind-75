class Solution {
public:
    vector<int> minSubsequence(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int s1 = 0, s2 = 0;
        for(int x : nums) s1 += x;
        vector<int> res;
        for(int i = nums.size() - 1; i >= 0; i--) {
            s1 -= nums[i];
            s2 += nums[i];
            res.push_back(nums[i]);
            if(s2 > s1) {
                break;
            }
        } 
        return res;
    }
};