
/**
 * @author suho kim
 * @no 2638
 * @title 치즈
 * @url https://www.acmicpc.net/problem/2638
 * @date 2021.10.12
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
  static int[] moveRow = { -1, 1, 0, 0 };
  static int[] moveCol = { 0, 0, -1, 1 };

  static int[][] map;
  static int cheeseCount;

  static int N;
  static int M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    cheeseCount = 0;
    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 1) {
          ++cheeseCount;
        }
      }
    }

    int time = 0;
    while (cheeseCount > 0) {
      ++time;
      run();
    }

    System.out.println(time);
  }

  private static void run() {
    Queue<Pair> q = new LinkedList<Pair>();
    q.offer(new Pair(0, 0));
    boolean[][] visited = new boolean[N][M];
    while (!q.isEmpty()) {
      Pair pair = q.poll();

      for (int i = 0; i < 4; ++i) {
        int nextRow = pair.row + moveRow[i];
        int nextCol = pair.col + moveCol[i];

        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M || visited[nextRow][nextCol])
          continue;

        if (map[nextRow][nextCol] == 0) {
          visited[nextRow][nextCol] = true;
          q.offer(new Pair(nextRow, nextCol));
        } else {
          ++map[nextRow][nextCol];
        }
      }
    }
    melted();
  }

  private static void melted() {
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < M; ++j) {
        if (map[i][j] > 2) {
          map[i][j] = 0;
          --cheeseCount;
        } else if (map[i][j] > 1) {
          map[i][j] = 1;
        }
      }
    }
  }
}
