
class Point implements Comparable<Point>{
    int x; int y ; int dist;
    Point(int x1, int y1){
        x = x1;
        y = y1;
        dist = (x*x) + (y*y);
    }
    public int compareTo(Point p){
        if(dist >= p.dist) return -1;
        else return 1;
    }
}


class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Point> pq = new PriorityQueue<Point>();
        
        //building maxHeap for k elements
        for(int i = 0; i < k; i++){
            pq.add(new Point(points[i][0], points[i][1]));
        }
        //for every new element less than the top, delete top and insert new
        for(int i = k; i < points.length; i++){
            int dist = (points[i][0]*points[i][0]) + (points[i][1]*points[i][1]);
            if(pq.peek().dist > dist){
                pq.poll();
                pq.add(new Point(points[i][0], points[i][1]));
            }
        }
        //return last k closest elements
        int[][] res = new int[pq.size()][2];
        int i = 0;
        while(pq.isEmpty()==false){
            Point p = pq.poll();
            res[i][0] = p.x;
            res[i][1] = p.y;
            i++;
        }
        return res;
    }
}