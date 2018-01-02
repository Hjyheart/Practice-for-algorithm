package src;

import java.util.*;

/**
 * Created by hongjiayong on 2017/12/10.
 * Tag: Heap
 * Solution:
 * 这个题一开始就知道是bfs 但是没用上优先队列就一直超时 每次都弹出最短时间的就可以了
 */
public class LeetCode734_NetworkDelayTime {

    static class Point{
        int k;
        int w;
        int startTime;
        public Point(int k, int w, int startTime) {
            this.k = k;
            this.w = w;
            this.startTime = startTime;
        }
    }

    static class compare implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            Point p1 = (Point) o1;
            Point p2 = (Point) o2;
            return p1.w + p1.startTime - p2.w - p2.startTime;
        }
    }


    public static int networkDelayTime(int[][] times, int N, int K) {

        ArrayList<int[]> disMap = new ArrayList<>();
        int[] bfsMap = new int[N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            bfsMap[i] = -1;
            disMap.add(new int[N]);
            for (int k = 0; k < N; k++) {
                disMap.get(i)[k] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < times.length; i++) {
            disMap.get(times[i][0] - 1)[times[i][1] - 1] = times[i][2];
        }

        PriorityQueue<Point> queue = new PriorityQueue<>(new compare());

        queue.add(new Point(K - 1, 0, 0));

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (bfsMap[current.k] != -1) {
                continue;
            }

            bfsMap[current.k] = current.startTime + current.w;
            count++;
            if (count == N) {
                return bfsMap[current.k];
            }

            int[] tmp = disMap.get(current.k);

            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i] != Integer.MAX_VALUE) {
                    queue.add(new Point(i, tmp[i], bfsMap[current.k]));
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2));
        System.out.println(networkDelayTime(new int[][]{{1,2,1}}, 2, 2));
        System.out.println(networkDelayTime(new int[][]{{1,2,1},{2,3,2},{1,3,4}}, 3, 1));
        System.out.println(networkDelayTime(new int[][]{{3,5,78},{2,1,1},{1,3,0},{4,3,59},{5,3,85},{5,2,22},{2,4,23},{1,4,43},{4,5,75},{5,1,15},{1,5,91},{4,1,16},{3,2,98},{3,4,22},{5,4,31},{1,2,0},{2,5,4},{4,2,51},{3,1,36},{2,3,59}}, 5, 5));
    }
}
