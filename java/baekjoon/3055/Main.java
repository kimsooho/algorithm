
/**
 * @author suho kim
 * @no 3055
 * @title 탈출
 * @url https://www.acmicpc.net/problem/3055
 * @date 2021.09.25
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

  static char[][] map;
  static int R;
  static int C;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    Pair posGoal = null;
    Queue<Pair> qHedgehog = new LinkedList<Pair>();
    Queue<Pair> qWater = new LinkedList<Pair>();

    map = new char[R][C];
    for (int r = 0; r < R; ++r) {
      String[] split = br.readLine().split("");
      for (int c = 0; c < C; ++c) {
        map[r][c] = split[c].charAt(0);
        if (map[r][c] == 'D') {
          posGoal = new Pair(r, c);
        } else if (map[r][c] == 'S') {
          qHedgehog.offer(new Pair(r, c));
        } else if (map[r][c] == '*') {
          qWater.offer(new Pair(r, c));
        }
      }
    }

    int moveCount = bfs(posGoal, qHedgehog, qWater);
    System.out.println(moveCount == -1 ? "KAKTUS" : moveCount);
  }

  private static int bfs(Pair posGoal, Queue<Pair> qHedgehog, Queue<Pair> qWater) {

    int moveCount = 0;
    while (!qHedgehog.isEmpty()) {
      ++moveCount;
      Queue<Pair> qTempWater = new LinkedList<Pair>();
      while (!qWater.isEmpty()) {
        Pair pair = qWater.poll();
        for (int i = 0; i < 4; ++i) {
          int nextRow = pair.row + moveRow[i];
          int nextCol = pair.col + moveCol[i];

          if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C || map[nextRow][nextCol] != '.')
            continue;

          qTempWater.offer(new Pair(nextRow, nextCol));
          map[nextRow][nextCol] = '*';
        }
      }

      qWater = new LinkedList<Pair>(qTempWater);

      Queue<Pair> qTempHedgehog = new LinkedList<Pair>();

      while (!qHedgehog.isEmpty()) {
        Pair pair = qHedgehog.poll();
        for (int i = 0; i < 4; ++i) {
          int nextRow = pair.row + moveRow[i];
          int nextCol = pair.col + moveCol[i];

          if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C
              || !(map[nextRow][nextCol] == '.' || map[nextRow][nextCol] == 'D'))
            continue;

          if (map[nextRow][nextCol] == 'D') {
            return moveCount;
          }
          qTempHedgehog.offer(new Pair(nextRow, nextCol));
          map[nextRow][nextCol] = '*';
        }
      }

      qHedgehog = new LinkedList<Pair>(qTempHedgehog);
    }
    return -1;
  }
}
