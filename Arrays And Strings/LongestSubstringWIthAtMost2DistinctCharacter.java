class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        int[] hash_char = new int[256];
        int i = 0, count = 1, maxLen = Integer.MIN_VALUE;
        hash_char[s.charAt(i)]++;
        for(int j = 1; j < s.length(); j++){
            if(hash_char[s.charAt(j)] == 0){
                count++;
            }
            hash_char[s.charAt(j)]++;
            if(count < 3) maxLen = Math.max(maxLen, j-i+1);
            while(count == 3){
               hash_char[s.charAt(i)]--;
                if(hash_char[s.charAt(i)] == 0){
                    count--;
                }
                i++;
            }
        }
        return maxLen == Integer.MIN_VALUE ? s.length() : maxLen;
    }
}