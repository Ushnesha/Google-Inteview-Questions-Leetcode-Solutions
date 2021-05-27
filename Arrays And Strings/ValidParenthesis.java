class Solution {
    public boolean isValid(String s) {
        Stack<Character> bkts = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)== '(' || s.charAt(i) == '{' || s.charAt(i) == '[') bkts.push(s.charAt(i));
            else{
                if(s.charAt(i)== ')'){
                    if(!bkts.empty() && bkts.peek() == '(')
                        bkts.pop();
                    else return false;
                }
                if(s.charAt(i)== '}'){
                    if(!bkts.empty() && bkts.peek() == '{')
                        bkts.pop();
                    else return false;
                }
                if(s.charAt(i)== ']'){
                    if(!bkts.empty() && bkts.peek() == '[')
                        bkts.pop();
                    else return false;
                }
            }   
        }
        if(bkts.empty()) return true;
        else return false;
    }
}