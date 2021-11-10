
/**
 * @author suho kim
 * @no 2468
 * @title 안전 영역
 * @url https://www.acmicpc.net/problem/2468
 * @date 2021.11.10
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
  int row;
  int col;

  public Pair(int row, int col) {
    this.row = row;
    this.col = col;
  }
}

public class Main {
  static int[][] map;
  static int N;
  static boolean[][] visited;

  static int[] moveRow = { -1, 1, 0, 0 };
  static int[] moveCol = { 0, 0, -1, 1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    map = new int[N][N];

    int maxVal = 0;
    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
        maxVal = Math.max(maxVal, map[i][j]);
      }
    }

    int result = 0;
    for (int i = 0; i < maxVal; ++i) {
      visited = new boolean[N][N];
      int count = 0;
      for (int row = 0; row < N; ++row) {
        for (int col = 0; col < N; ++col) {
          if (map[row][col] > i && !visited[row][col]) {
            run(i, row, col);
            ++count;
          }
        }
      }

      result = Math.max(result, count);
    }
    System.out.println(result);
  }

  private static void run(int h, int row, int col) {
    Queue<Pair> q = new LinkedList<Pair>();
    q.offer(new Pair(row, col));
    visited[row][col] = true;

    while (!q.isEmpty()) {
      Pair pair = q.poll();

      for (int i = 0; i < 4; ++i) {
        int nextRow = pair.row + moveRow[i];
        int nextCol = pair.col + moveCol[i];

        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N || visited[nextRow][nextCol]
            || map[nextRow][nextCol] <= h)
          continue;

        visited[nextRow][nextCol] = true;
        q.offer(new Pair(nextRow, nextCol));
      }
    }
  }
}
