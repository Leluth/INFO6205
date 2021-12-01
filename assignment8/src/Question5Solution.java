import java.util.ArrayList;
import java.util.List;

/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question5Solution
 * @date 2021/11/30 18:40
 */
public class Question5Solution {
    public static void main(String[] args) {
        Question5Solution solution = new Question5Solution();
        System.out.println(solution.countComponents(5, new int[][]{{0,1},{1,2},{3,4}}));
        System.out.println(solution.countComponents(5, new int[][]{{0,1},{1,2},{2,3},{3,4}}));
    }

    // E is number of edges, V is  number of vertice
    // Time: O(E+V)
    // Space: O(E+V)
    public int countComponents(int n, int[][] edges) {
        int components = 0;
        int[] visited = new int[n];
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                components++;
                dfs(adjList, visited, i);
            }
        }
        return components;
    }

    private void dfs(List<Integer>[] adjList, int[] visited, int startNode) {
        visited[startNode] = 1;
        for (int i = 0; i < adjList[startNode].size(); i++) {
            if (visited[adjList[startNode].get(i)] == 0) {
                dfs(adjList, visited, adjList[startNode].get(i));
            }
        }
    }
}
