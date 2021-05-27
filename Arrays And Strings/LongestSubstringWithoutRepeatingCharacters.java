//e.g Input: "pwwkew" Output: 3
//e.g Input: "bbbbb" Output: 1

//<----------------------------------------------SOLUTION---------------------------------------------->

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIdx = new int[256];
        Arrays.fill(lastIdx, -1);
        int res = 0, i = 0;
        for(int j = 0; j < s.length(); j++){
            i = Math.max(i, lastIdx[s.charAt(j)]+1);
            res = Math.max(res, j-i+1);
            lastIdx[s.charAt(j)] = j;
        }
        return res;
    }
}