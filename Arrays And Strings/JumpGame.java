class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] vis = new Boolean[nums.length];
        Arrays.fill(vis, false);
        vis[0] = true;
        for(int i = 0; i < nums.length-1; i++){
            for(int j = 1; i+j < nums.length && j <= nums[i]; j++){
                if(!vis[i+j]) vis[i+j] = true;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(!vis[i]) return false;
        }
        return true;
    }
}