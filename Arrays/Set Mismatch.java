/*
 * Leetcode problem : https://leetcode.com/problems/set-mismatch/
 */
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];

        for(int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0) {
                ans[0] = index + 1;
            }else {
                nums[index] = -1 * nums[index];
            }
        }
        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                ans[1] = i + 1;
                break;
            }
        }
        return ans;
    }
}