/*
 * Leetcode problem : https://leetcode.com/problems/sum-of-subarray-minimums/description/
 */

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int[] NSL = getNSL( arr,  n);
        int[] NSR = getNSR(arr,  n);

        long result = 0;
        int mod = (int)1e9 + 7;

        for(int i = 0; i < n; i++) {
            int ls = i - NSL[i];
            int rs = NSR[i] - i;

            long noOfSub = ls * rs;
            long sum = noOfSub * arr[i];

            result = (result + sum) % mod;
        }
        return (int)result;
    }

    public int[] getNSL(int[] arr, int n) {
        int[] ans = new int[n];
        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i < n; i++) {
            if(stk.isEmpty()) {
                ans[i] = -1;
            }else {
                while(!stk.isEmpty() && arr[stk.peek()] > arr[i]) {
                    stk.pop();
                }
                ans[i] = stk.isEmpty() ? -1 : stk.peek();
            }
            stk.push(i);
        }

        return ans;
    }
    public int[] getNSR(int[] arr, int n) {
        int[] ans = new int[n];
        Stack<Integer> stk = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            if(stk.isEmpty()) {
                ans[i] = n;
            }else {
                while(!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
                    stk.pop();
                }
                ans[i] = stk.isEmpty() ? n : stk.peek();
            }
            stk.push(i);
        }
        return ans;
    }
}