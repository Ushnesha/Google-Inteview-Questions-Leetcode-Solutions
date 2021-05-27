class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n == 1) return;
        int i;
        for(i = n-2; i >= 0; i--){
            if(nums[i] < nums[i+1]) break;
        }
        if(i >= 0) swap(nums, i, nge(i, nums));
        Arrays.sort(nums, i+1, n);
    }
    int nge(int idx, int[] nums){
        int curSmall = Integer.MAX_VALUE;
        int curIdx = -1;
        for(int i = idx+1; i < nums.length; i++)
            if(nums[i] > nums[idx] && curSmall > nums[i]){
                curSmall = nums[i];
                curIdx = i;
            }
        return curIdx;
    }
    void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}