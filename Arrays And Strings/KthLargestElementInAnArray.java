class Solution {
    public int findKthLargest(int[] nums, int k) {
        //construct min heap of k elements
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i < k; i++){
            pq.add(nums[i]);
        }
        //for every new element greater than the top, delete top and insert new
        for(int i = k; i < nums.length; i++){
            if(pq.peek()<nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        //return the top of last 4 greatest elements
        return pq.peek();
    }
}