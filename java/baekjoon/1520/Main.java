
/**
 * @author suho kim
 * @no 1520
 * @title 내리막 길
 * @url https://www.acmicpc.net/problem/1520
 * @date 2021.10.21
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] moveRow = { -1, 1, 0, 0 };
  static int[] moveCol = { 0, 0, -1, 1 };

  static int[][] map;
  static int[][] memo;
  static int M;
  static int N;

  static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    map = new int[M][N];
    memo = new int[M][N];

    count = 0;

    for (int i = 0; i < M; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
        memo[i][j] = -1;
      }
    }
    System.out.println(dfs(M - 1, N - 1));
  }

  private static int dfs(int row, int col) {
    if ((row == 0 && col == 0)) {
      return 1;
    }

    if (memo[row][col] == -1) {
      memo[row][col] = 0;
      for (int i = 0; i < 4; ++i) {
        int nextRow = row + moveRow[i];
        int nextCol = col + moveCol[i];

        if (nextRow < 0 || nextRow >= M || nextCol < 0 || nextCol >= N || map[nextRow][nextCol] <= map[row][col])
          continue;

        memo[row][col] += dfs(nextRow, nextCol);
      }
    }
    return memo[row][col];
  }
}
