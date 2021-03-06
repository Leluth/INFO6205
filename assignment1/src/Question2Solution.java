import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question2 Solution
 * @date 2021/9/14 20:41
 */
public class Question2Solution {
    /**
     * @description: main function
     * @param: [args]
     * @return: void
     * @author: ssxu
     * @date: 2021/9/14 20:33
     */
    public static void main(String[] args) {
        Question2Solution solution = new Question2Solution();
        Interval[] data1 = new Interval[]{new Interval(0, 30), new Interval(15, 20), new Interval(5, 10)};
        boolean res1 = solution.checkIntervals(data1);
        System.out.println(res1);
        Interval[] data2 = new Interval[]{new Interval(7, 10), new Interval(2, 4)};
        boolean res2 = solution.checkIntervals(data2);
        System.out.println(res2);
    }

    private static class Interval {
        private final int start;
        private final int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // n is the length of intervals
    // Time: O(n * log(n))
    // Space: O(1)
    public boolean checkIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length < 2) {
            return true;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return 0;
                }
                return o1.start < o2.start ? -1 : 1;
            }
        });
        Interval pre = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            Interval cur = intervals[i];
            if (pre.end > cur.start) {
                return false;
            }
            pre = cur;
        }
        return true;
    }
}
