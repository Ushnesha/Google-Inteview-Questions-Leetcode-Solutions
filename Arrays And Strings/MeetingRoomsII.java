class Interval{
    int start;
    int end;
    Interval(int s, int e){
        start = s;
        end = e;
    }
}



class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        if(n == 0) return 0;
        Interval[] intrvls = new Interval[n];
        for(int i = 0; i < intervals.length; i++){
            intrvls[i] = new Interval(intervals[i][0], intervals[i][1]);
        }
        
        //sort the intervals corresponding to start time
        Arrays.sort(intrvls, (a,b) -> a.start - b.start);
        //minheap corresponding to end time
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> a.end - b.end);
        pq.add(intrvls[0]);
        for(int i = 1; i<n; i++){
            Interval current = intrvls[i];
            Interval earliest = pq.remove();
            if(current.start >= earliest.end){
                earliest.end = current.end;
            }else{
                pq.add(current);
            }
            pq.add(earliest);
        }
        return pq.size();
        // return 0;
    }
}