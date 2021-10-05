
/**
 * @author suho kim
 * @no 1844
 * @title 게임 맵 최단거리
 * @url https://programmers.co.kr/learn/courses/30/lessons/1844
 * @date 2021.10.05
 */
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    int result = s.solution(
        new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1 } });

    System.out.println(result);

  }
}

class Solution {
  int[] moveRow = { -1, 1, 0, 0 };
  int[] moveCol = { 0, 0, -1, 1 };

  boolean[][] visited;

  public int solution(int[][] maps) {
    int N = maps.length;
    int M = maps[0].length;

    visited = new boolean[N][M];
    Queue<Pair> q = new LinkedList<Pair>();
    q.offer(new Pair(0, 0));
    visited[0][0] = true;
    while (!q.isEmpty()) {
      Pair pair = q.poll();
      if (pair.row == N - 1 && pair.col == M - 1)
        return maps[N - 1][M - 1];
      for (int i = 0; i < 4; ++i) {
        int nextRow = pair.row + moveRow[i];
        int nextCol = pair.col + moveCol[i];

        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M || maps[nextRow][nextCol] == 0
            || visited[nextRow][nextCol])
          continue;

        maps[nextRow][nextCol] = maps[pair.row][pair.col] + 1;
        visited[nextRow][nextCol] = true;
        q.offer(new Pair(nextRow, nextCol));
      }
    }
    return -1;
  }
}

class Pair {
  int row;
  int col;

  public Pair(int row, int col) {
    this.row = row;
    this.col = col;
  }
}
