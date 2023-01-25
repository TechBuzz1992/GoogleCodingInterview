package Day_0125;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class EmployeeFreeTime {
    class Interval{
        int start;
        int end;

        Interval(int a, int b){
            this.start = a;
            int end = b;
        }
    }
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start != b.start? a.start - b.start: a.end - b.end);

        for(List<Interval> intervals: schedule) {
            for(Interval interval: intervals) {
                pq.offer(interval);
            }
        }

        if(pq.isEmpty()) return res;

        Interval pre = pq.poll();

        while(!pq.isEmpty()) {
            Interval cur = pq.poll();
            if(pre.end < cur.start) {
                res.add(new Interval(pre.end, cur.start));
            } else {
                cur.start = Math.min(pre.start, cur.start);
                cur.end = Math.max(pre.end, cur.end);
            }
            pre = cur;
        }

        return res;
    }
}