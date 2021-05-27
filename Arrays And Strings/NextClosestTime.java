class Solution {
    public String nextClosestTime(String time) {
        
        //for keeping the next greater number of the number and keep it sorted
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        //to copy the unique elements from treemap to arraylist
        ArrayList<Integer> timeChar = new ArrayList<Integer>();
        
        int j = 1;
        
        //initially putting the digits with 0
        for(int i = 0; i < time.length(); i++){
            if(Character.isDigit(time.charAt(i))) {
                tm.put((time.charAt(i)-'0'), 0);
            }
        }
        
        //storing the elements in an arraylist too
        for(int keys : tm.keySet()) timeChar.add(keys);
        
        //iterating over the tree map and putting numbers just greater than the numbers to its value
        Iterator<Map.Entry<Integer, Integer>> itr = tm.entrySet().iterator();
        while(j < timeChar.size() && itr.hasNext()){
            Map.Entry<Integer, Integer> entry = itr.next();
            tm.put(entry.getKey(),timeChar.get(j++));
        }
        //putting -1 with the largest number
        tm.put(tm.lastKey(), -1);
        
        //converting time string to character array to manipulate the characters
        char[] time_ = new char[time.length()];
        int i;
        
        for(i = time.length()-1; i >= 0; i--){
            //if not digit then continue
            if(time.charAt(i)==':') continue;
            time_ = time.toCharArray();
            //get the nxt greater number of the current number
            int nxtGrt = tm.get((time_[i])-'0');
            //if next greater number == -1 or the number is largest then continue
            if(nxtGrt == -1) continue;
            //substitute the current character with the next greater number and all 
            //succeeding numbers with the lowest value
            time_[i] = (char)(nxtGrt+'0');
            for(int k = i+1; k < time.length(); k++){
                if(k == 2){
                    time_[k]=':';
                    continue;
                }
                time_[k] = (char)(tm.firstKey()+'0');
            }
            //if the changed time is valid then break, we get the next closest time
            if(isTimeValid(new String(time_))){
                break;
            }
        }
        if(i == -1){
            for(int k = 0; k < time.length(); k++){
                if(k == 2){
                    time_[k]=':';
                    continue;
                }
                time_[k] = (char)(tm.firstKey()+'0');
            }
        }
        return new String(time_);
    }
    public boolean isTimeValid(String time){
        String hh = time.substring(0,2);
        String mm = time.substring(3);
        return (isValidHour(hh) && isValidMin(mm));
    }
    public boolean isValidHour(String hh){
        return (Integer.parseInt(hh) < 24 && Integer.parseInt(hh) >= 0);
    }
    public boolean isValidMin(String mm){
        return (Integer.parseInt(mm) < 60 && Integer.parseInt(mm) >= 0);
    }
}