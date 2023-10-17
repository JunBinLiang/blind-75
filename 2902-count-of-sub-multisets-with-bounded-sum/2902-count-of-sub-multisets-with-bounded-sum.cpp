const int MOD = 1e9 + 7;
class Solution {
public:
    int countSubMultisets(vector<int>& nums, int l, int r) {
        sort(nums.begin(), nums.end());
        return (get(nums, r) - get(nums, l - 1) + MOD) % MOD;
    }
    
    int get(vector<int>& nums, int k) {
        if(k < 0) return 0;
        int n = nums.size();
        int tot = 0;
        for(int x : nums) tot += x;
        
        vector<int> dp(tot + 1);
        vector<int> p(tot + 1);
        p[0] = 1;
        
        for(int i = 0; i < n; i++) {
            int j = i, cnt = 0;
            while(j < n && nums[i] == nums[j]) {
                j++;
                cnt++;
            }
            
            if(nums[i] == 0) {
                i = j - 1;
                p[0] += cnt;
                continue;
            }
            
            int x = nums[i];
            for(int c = x; c <= tot; c++) {
                if(c < (cnt + 1) * x) {
                    dp[c] = dp[c - x] + p[c - x];
                    dp[c] %= MOD;
                } else {
                    dp[c] = dp[c - x] + p[c - x];
                    dp[c] %= MOD;
                    dp[c] -= p[c - (cnt + 1) * x];
                    if(dp[c] < 0) dp[c] += MOD;
                }
            }
            
            for(int c = 0; c <= tot; c++) {
                p[c] += dp[c];
                p[c] %= MOD;
                dp[c] = 0;
            }
            i = j - 1;
        }

        int res = 0;
        for(int i = 0; i <= min(k, tot); i++) {
            res += p[i];
            res %= MOD;
        }
        return res;
    }
};
//      p[0]     p[2]        p[4]                p[6]                      p[8]                 p[10]
//dp             p[0]        p[0] + p[2]         p[0] + p[2] + p[4]        p[2] + p[4] + p[6]   p[4] + p[6] + p[8]