// You are given a license key represented as a string s that consists of only alphanumeric characters and dashes. The string is separated into n + 1 groups by n dashes. You are also given an integer k.

// We want to reformat the string s such that each group contains exactly k characters, except for the first group, which could be shorter than k but still must contain at least one character. Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.

// Return the reformatted license key.

//e.g Input: s = "5F3Z-2e-9-w", k = 4 Output: "5F3Z-2E9W"
//e.g Input: s = "2-5g-3-J", k = 2 Output: "2-5G-3J"

//<----------------------------------------------SOLUTION---------------------------------------------->
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        int n=K; 
        String st="", stRev="";
        for(int i = S.length()-1; i>=0; i--){
            if(Character.isLetterOrDigit(S.charAt(i))){
                st += Character.isDigit(S.charAt(i)) ? S.charAt(i) : Character.toUpperCase(S.charAt(i));
                n--;
                if(n==0) {
                    st+='-';
                    n=K;
                }
            }
        }
        if(st == "") return st;
        int i = st.length()-1;
        if(st.charAt(i)=='-') i--;
        for(; i>=0; i--) stRev+=st.charAt(i);
        return stRev;
    }
}


