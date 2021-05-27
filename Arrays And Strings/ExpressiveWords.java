class Solution {
    public int expressiveWords(String s, String[] words) {
        if(s.length() == 0 || words.length == 0) return 0;
        ArrayList<String> sArr = getGroups(s);
        // System.out.println(sArr.toString());
        int count = 0;
        for(String word : words){
            if(word.length() == 0) continue;
            ArrayList<String> wordArr = getGroups(word);
            // System.out.println(wordArr.toString());
            if(sArr.size() == wordArr.size()){
                // System.out.println(wordArr.toString());
                boolean flag = true;
                for(int i = 0; i < sArr.size(); i++){
                    if(sArr.get(i).equals(wordArr.get(i))){
                        continue;
                    }
                    if(sArr.get(i).length() < wordArr.get(i).length() ||
                       sArr.get(i).charAt(0)!=wordArr.get(i).charAt(0) ||
                        (sArr.get(i).charAt(0)==wordArr.get(i).charAt(0) &&
                        sArr.get(i).length() < 3)){
                        // System.out.println(sArr.get(i)+" "+wordArr.get(i));
                        flag = false;
                        break;
                    }
                }
                if(flag) count++;
            }
        }
        return count;
    }
    public ArrayList<String> getGroups(String S){
        ArrayList<String> res = new ArrayList<String>();
        String s=Character.toString(S.charAt(0));
        int i = 1;
        while(i < S.length()){
            while(i < S.length() && S.charAt(i) == S.charAt(i-1)){
                s+=S.charAt(i);
                i++;
            }
            if(i < S.length() && S.charAt(i) != S.charAt(i-1)){
                res.add(s);
                s=Character.toString(S.charAt(i));
                i++;
            }
        }
        res.add(s);
        return res;
    }
}