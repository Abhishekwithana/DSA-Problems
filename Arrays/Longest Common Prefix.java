/**
 *  Leetcode Problem : https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/description/
 */
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < arr1.length; i++) {
            int num = arr1[i];

            while(num > 0) {
                set.add(num);
                
                num /= 10;
            }
        }

        int max = 0;

        for(int i = 0; i < arr2.length; i++) {
            int num = arr2[i];

            while(num > 0) {
                if(set.contains(num)) {
                    max = Math.max(max, (int)Math.log10(num) + 1);
                }

                num /= 10;
            }
        }
        return max;
    }
}