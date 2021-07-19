class Pair{
    double ratio;
    int quality;
    Pair(double r, int q){
        ratio = r;
        quality = q;
    }
}


class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Pair[] workers = new Pair[n];
        //we need to use the ratio (wage to quality) and the quality. 
        for(int i = 0; i < n; i++){
            workers[i] = new Pair((double)wage[i]/quality[i], quality[i]);
        }
        //sort the workers wrt ratio
        Arrays.sort(workers, (a,b) -> Double.compare(a.ratio,b.ratio));
        //now use a maxHeap to get k smallest quality out of the sorted workers
        PriorityQueue<Integer> minQualities = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        //get the sum of first k elements
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum+=workers[i].quality;
            minQualities.add(workers[i].quality);
        }
        //we initialise ans with sum of first k elements multiplies 
        //ratio of the kth worker since it is sorted
        double ans = sum * workers[k-1].ratio;
        //now for every new element we check if the quality is less than the top, 
        //if yes then we replace the top with the new quality
        for(int i = k; i < n; i++){
            if(minQualities.peek() > workers[i].quality){
                int x = minQualities.poll();
                minQualities.add(workers[i].quality);
                sum+=workers[i].quality-x;
                ans = Math.min(ans, sum * workers[i].ratio);
            }
        }
        return ans;
    }
}