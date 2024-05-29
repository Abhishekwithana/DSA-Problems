/* 
 * Leetcode problem : https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/description/
 */

class Solution {
	public int numSteps(String s) {

		char[] arr = s.toCharArray();
		int n = arr.length, ans = 0;

		for(int i = n - 1; i > 0; i--) {
			int j = i;
			if(arr[i] == '1') {
				while(j >= 0 && arr[j] == '1') {
					j--;
				}
				ans += (i - j + 1);

				if(j >= 0) arr[j] = '1';
			}else {
				
				while(j >= 0 && arr[j] == '0') {
					j--;
				}
				ans += (i - j);
			}
			
			i = j + 1;
			
		}
	return ans;	
	
	}

}
	

