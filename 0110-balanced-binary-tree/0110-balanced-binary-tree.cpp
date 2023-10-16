/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool res = true;
    bool isBalanced(TreeNode* root) {
        h(root);
        return res;
    }
    int h(TreeNode* root) {
        if(root == NULL) return 0;
        int l = h(root -> left) + 1, r = h(root -> right) + 1;
        if(abs(l - r) > 1) {
            res = false;
        }
        return max(l, r);
    }
};