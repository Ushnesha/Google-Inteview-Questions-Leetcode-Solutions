class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        String s1 = "";
        for(int i = 0; i < num2.length(); i++){
            int carry = 0;
            String s = "";
            for(int j = num1.length()-1; j >= 0; j--){
                int curMul = (num2.charAt(i)-'0')*(num1.charAt(j)-'0');
                int finalMul = curMul+carry;
                s = String.valueOf(finalMul%10) + s;
                carry = finalMul/10;
            }
            if(carry != 0) s = String.valueOf(carry)+s;
            s1 = add((s1+'0'),s);
        }
        return s1;
    }
    
    public String add(String n1, String n2){
        int i = n1.length()-1, j = n2.length()-1;
        String res = "";
        int carry = 0;
        while(i>=0 && j>=0){
            int sum = (n1.charAt(i)-'0')+(n2.charAt(j)-'0')+carry;
            res = String.valueOf(sum%10) + res;
            carry = sum/10;
            i--; j--;
        }
        while(i>=0){
            int sum = (n1.charAt(i)-'0')+carry;
            res = String.valueOf(sum%10) + res;
            carry = sum/10;
            i--;
        }
        while(j>=0){
             int sum = (n2.charAt(j)-'0')+carry;
            res = String.valueOf(sum%10) + res;
            carry = sum/10;
            j--;
        }
        if(carry>0) res = String.valueOf(carry) + res;
        return res;
    }
}
