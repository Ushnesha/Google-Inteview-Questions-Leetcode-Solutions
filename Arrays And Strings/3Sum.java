class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> st = new HashSet<List<Integer>>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = i+1, k = n-1; j < k;){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    st.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[k])));
                    j++;
                    k--;
                }else if(sum < 0)
                    j++;
                else k--;
            }
        }
        ans.addAll(st);
        return ans;
    }
}
