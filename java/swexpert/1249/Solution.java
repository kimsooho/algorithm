
/**
 * @author suho kim
 * @no 1249
 * @title 보급로
 * @date 2021.09.30
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Info implements Comparable<Info> {
  int row;
  int col;
  int cost;

  public Info(int row, int col, int cost) {
    this.row = row;
    this.col = col;
    this.cost = cost;
  }

  @Override
  public int compareTo(Info o) {
    return this.cost - o.cost;
  }
}

public class Solution {
  static int[][] map;
  static int[][] cost;

  static int[] moveRow = { -1, 1, 0, 0 };
  static int[] moveCol = { 0, 0, -1, 1 };

  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; ++t) {
      N = Integer.parseInt(br.readLine());

      map = new int[N][N];
      cost = new int[N][N];

      for (int i = 0; i < N; ++i) {
        String[] split = br.readLine().split("");
        for (int j = 0; j < N; ++j) {
          map[i][j] = Integer.valueOf(split[j]);
          cost[i][j] = Integer.MAX_VALUE;
        }
      }

      System.out.println(String.format("#%d %d", t, run()));
    }
  }

  private static int run() {
    PriorityQueue<Info> pq = new PriorityQueue<Info>();
    pq.offer(new Info(0, 0, 0));
    cost[0][0] = 0;

    while (!pq.isEmpty()) {
      Info info = pq.poll();

      for (int i = 0; i < 4; ++i) {
        int nextRow = info.row + moveRow[i];
        int nextCol = info.col + moveCol[i];

        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N
            || cost[nextRow][nextCol] <= info.cost + map[nextRow][nextCol])
          continue;

        cost[nextRow][nextCol] = info.cost + map[nextRow][nextCol];

        pq.offer(new Info(nextRow, nextCol, cost[nextRow][nextCol]));
      }
    }
    return cost[N - 1][N - 1];
  }
}
