class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        digits[n-1] += 1;
        if (digits[n-1]<10) return digits;
        int carry = 0;
        for(int i = n-1; i >= 0; i--){
            int elem = digits[i] + carry;
            carry = elem / 10;
            digits[i] = elem % 10;
            if(carry == 0){
                break;
            }
        }
        if(carry == 1){
            int[] newDigits = new int[n+1];
            newDigits[0] = 1;
            for(int i = 1; i < n+1; i++) newDigits[i] = 0;
            return newDigits;
        }
        return digits;
    }
}