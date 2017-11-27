package src;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by I332329 on 11/27/2017.
 */
public class InsertInterval_57 {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        ArrayList<Interval> res = new ArrayList<>();
        boolean flag = false;
        int i = 0;
        int point = -1;
        while (i < intervals.size()) {
            if (res.size() > 0) {
                if (!flag) {
                    if (intervals.get(i).start > newInterval.start) {
                        if (res.get(point).end >= newInterval.start) {
                            res.get(point).end = Math.max(res.get(point).end, newInterval.end);
                        } else{
                            res.add(newInterval);
                            point++;
                        }
                        flag = true;
                        continue;
                    }
                }
                if (res.get(point).end < intervals.get(i).start) {
                    res.add(intervals.get(i));
                    i++;
                    point++;
                } else if (res.get(point).end >= intervals.get(i).start) {
                    res.get(point).end = Math.max(intervals.get(i).end, res.get(point).end);
                    i++;
                }
            } else {
                if (intervals.get(i).start < newInterval.start) {
                    res.add(intervals.get(i));
                    i++;
                } else {
                    res.add(newInterval);
                    flag = true;
                }
                point++;
            }
        }
        if (!flag) {
            if (res.get(point).end >= newInterval.start) {
                res.get(point).end = Math.max(res.get(point).end, newInterval.end);
            } else{
                res.add(newInterval);
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        [[1,3],[6,9]]
//[2,5]
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 5));
//        list.add(new Interval(2, 9));
        insert(list, new Interval(2, 7));
    }
}
