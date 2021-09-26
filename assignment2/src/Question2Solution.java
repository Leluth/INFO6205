import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question2 Solution
 * @date 2021/9/21 18:39
 */
public class Question2Solution {
    public static void main(String[] args) {
        Question2Solution solution = new Question2Solution();
        int[][] data = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        System.out.println(solution.minRooms(data));
        data = new int[][]{{7, 10}, {2, 4}};
        System.out.println(solution.minRooms(data));
    }

    public int minRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        PriorityQueue<int[]> rooms = new PriorityQueue<>(intervals.length, Comparator.comparingInt(o -> o[1]));
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int[] interval : intervals) {
            if (!rooms.isEmpty() && interval[0] >= rooms.peek()[1]) {
                rooms.poll();
            }
            rooms.offer(interval);
        }
        return rooms.size();
    }
}
