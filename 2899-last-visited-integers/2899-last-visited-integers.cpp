class Solution {
public:
    vector<int> lastVisitedIntegers(vector<string>& a) {
        vector<int> nums, res;
        int j = -1;
        for(int i = 0; i < a.size(); i++) {
            if(a[i][0] == 'p') {
                j--;
                if(j < 0) res.push_back(-1);
                else res.push_back(nums[j]);
            } else {
                nums.push_back(stoi(a[i]));
                j = nums.size();
            }
        }
        return res;
    }
};