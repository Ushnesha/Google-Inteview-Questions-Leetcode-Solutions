class Solution {
    public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
        
        List<ReplaceComponent> repObjs = getLists(indexes, sources, targets);
        Collections.sort(repObjs,new Comparator<ReplaceComponent>(){
            public int compare(ReplaceComponent o1, ReplaceComponent o2)
            {
                return (o1.index-o2.index);
            }
        });
        int n = indexes.length;
        int sLen = s.length();
        int extra_add = 0;
        
        for(int i = 0; i < n; i++){
            ReplaceComponent obj = repObjs.get(i);
            int idx = (extra_add + obj.index);
            if(s.substring(idx, idx + obj.source.length()).equals(obj.source)){
                if(idx == 0)
                    s = obj.target + s.substring(idx + obj.source.length());
                else
                    s = s.substring(0,idx) + obj.target + s.substring(idx + obj.source.length());
                extra_add += obj.target.length()-obj.source.length();
            }
        }
        return s;
    }
    
    public List<ReplaceComponent> getLists(int[] indexes, String[] sources, String[] targets){
        List<ReplaceComponent> replaceObjs = new ArrayList<ReplaceComponent>();
        for(int i = 0; i < indexes.length; i++)
            replaceObjs.add(new ReplaceComponent(indexes[i], sources[i], targets[i]));
        return replaceObjs;
    }
    
    class ReplaceComponent{
        int index;
        String source;
        String target;
        
       public ReplaceComponent(int index, String source, String target){
           this.index = index;
           this.source = source;
           this.target = target;
       }
    }
}