
/**
 * @author suho kim
 * @no 2636
 * @title 치즈
 * @url https://www.acmicpc.net/problem/2636
 * @date 2021.09.15
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

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] cheese = new int[N][M];

    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; ++j) {
        cheese[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int time = 0;
    int cheeseCount = 0;
    while (true) {
      int meltedCount = run(cheese);
      if (meltedCount == 0)
        break;

      ++time;
      cheeseCount = meltedCount;
    }
    System.out.println(String.format("%d\n%d", time, cheeseCount));
  }

  private static int run(int[][] cheese) {

    boolean[][] visited = new boolean[cheese.length][cheese[0].length];
    int meltedCount = 0;
    Queue<Pair> q = new LinkedList<Pair>();
    q.offer(new Pair(0, 0));

    while (!q.isEmpty()) {
      Pair pair = q.poll();

      for (int i = 0; i < 4; ++i) {
        int nextRow = moveRow[i] + pair.row;
        int nextCol = moveCol[i] + pair.col;

        if (nextRow < 0 || nextRow >= cheese.length || nextCol < 0 || nextCol >= cheese[0].length
            || visited[nextRow][nextCol])
          continue;

        visited[nextRow][nextCol] = true;
        if (cheese[nextRow][nextCol] == 0) {
          q.offer(new Pair(nextRow, nextCol));
        } else {
          cheese[nextRow][nextCol] = 0;
          ++meltedCount;
        }
      }
    }
    return meltedCount;
  }
}
