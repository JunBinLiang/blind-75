class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int n = nums.size();
        int mx = 0, res = 0;
        for(int i = 0; i < n; i++) {
            int j = i;
            while(j < n && nums[i] == nums[j]) {
                j++;
            }
            
            if(nums[i] > mx) {
                mx = nums[i];
                res = j - i;
            } else if(nums[i] == mx) {
                res = max(res, j - i);
            }
            
            i = j - 1;
        }
        
        return res;
    }
};