class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList();
        int i = lower, j = 0;
        while(i <= upper && j < nums.length){
            if(i == nums[j]){
                i++;
                j++;
            }else{
                if(i == nums[j]-1) res.add(Integer.toString(i));
                else res.add(Integer.toString(i)+"->"+Integer.toString(nums[j]-1));
                i = nums[j]+1;
                j++;
            }
        }
        if(i <= upper){
            if(i == upper) res.add(Integer.toString(i));
            else res.add(Integer.toString(i)+"->"+Integer.toString(upper));
        }
        return res;
    }
}