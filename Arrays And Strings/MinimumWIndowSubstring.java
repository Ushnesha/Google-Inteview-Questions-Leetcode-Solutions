class Solution {
    public String minWindow(String s, String t) {
        
        int slen = s.length();
        int tlen = t.length();
        if(slen < tlen) return "";
        int[] hash_str = new int[256];
        int[] hash_pat = new int[256];
        
        for(int i = 0; i < tlen; i++) hash_pat[t.charAt(i)]++;
        
        int start = 0;
        int start_idx = -1;
        int count = 0, min_len = Integer.MAX_VALUE;
        for(int j = 0; j < slen; j++){
            hash_str[s.charAt(j)]++;
            if(hash_str[s.charAt(j)] <= hash_pat[s.charAt(j)]) count++;
            if(count == tlen){
                while(hash_str[s.charAt(start)] > hash_pat[s.charAt(start)]){
                    hash_str[s.charAt(start)]--;
                    start++;
                }
                int win_len = j - start + 1;
                if(min_len > win_len){
                    min_len = win_len;
                    start_idx = start;
                }
            }
        }
        if(start_idx == -1) return "";
        return s.substring(start_idx, start_idx + min_len);
    }
}