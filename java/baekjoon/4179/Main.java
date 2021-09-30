
/**
 * @author suho kim
 * @no 4179
 * @title 불!
 * @url https://www.acmicpc.net/problem/4179
 * @date 2021.09.30
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

  static int R;
  static int C;

  static char[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new char[R][C];
    Queue<Pair> qFire = new LinkedList<Pair>();
    Queue<Pair> q = new LinkedList<Pair>();
    for (int i = 0; i < R; ++i) {
      String[] split = br.readLine().split("");
      for (int j = 0; j < C; ++j) {
        map[i][j] = split[j].charAt(0);
        if (map[i][j] == 'F') {
          qFire.offer(new Pair(i, j));
        } else if (map[i][j] == 'J') {
          q.offer(new Pair(i, j));
        }
      }
    }

    int time = run(qFire, q);
    System.out.println(time == -1 ? "IMPOSSIBLE" : time);
  }

  private static int run(Queue<Pair> qFire, Queue<Pair> q) {
    int time = 0;
    while (!q.isEmpty()) {
      ++time;
      int fireSize = qFire.size();
      for (int i = 0; i < fireSize; ++i) {
        Pair pair = qFire.poll();
        for (int m = 0; m < 4; ++m) {
          int nextRow = pair.row + moveRow[m];
          int nextCol = pair.col + moveCol[m];
          if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C || map[nextRow][nextCol] != '.')
            continue;
          qFire.offer(new Pair(nextRow, nextCol));
          map[nextRow][nextCol] = '#';
        }
      }

      int jSize = q.size();
      for (int i = 0; i < jSize; ++i) {
        Pair pair = q.poll();
        if (pair.row == R - 1 || pair.col == C - 1 || pair.row == 0 || pair.col == 0)
          return time;

        for (int m = 0; m < 4; ++m) {
          int nextRow = pair.row + moveRow[m];
          int nextCol = pair.col + moveCol[m];
          if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C || map[nextRow][nextCol] != '.')
            continue;

          map[nextRow][nextCol] = '#';
          q.offer(new Pair(nextRow, nextCol));
        }
      }
    }
    return -1;
  }
}
