import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/7576

public class Main {
  static int xAxis[] = { -1, 0, 1, 0 };
  static int yAxis[] = { 0, -1, 0, 1 };

  static int[][] map;
  static Queue<pair> q = new LinkedList<>();

  static int M = 0;
  static int N = 0;

  static class pair {
    public int x;
    public int y;

    pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static void bfs() {
    while (!q.isEmpty()) {
      int x = q.peek().x;
      int y = q.peek().y;
      q.poll();

      for (int i = 0; i < 4; ++i) {
        int nextX = x + xAxis[i];
        int nextY = y + yAxis[i];

        if (nextX < 0 || nextY < 0 || 
        nextX > N - 1 || nextY > M - 1 || 
        map[nextX][nextY] != 0) {
          continue;
        }

        map[nextX][nextY] = map[x][y] + 1;
        q.add(new pair(nextX, nextY));
      }
    }
  }

  public static void main(String[] args) {
    int input;
    Scanner sc = new Scanner(System.in);

    M = sc.nextInt();
    N = sc.nextInt();

    map = new int[N][M];

    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < M; ++j) {
        input = sc.nextInt();

        if (input == 1) {
          q.add(new pair(i, j));
        }
        map[i][j] = input;
      }
    }

    bfs();

    int ret = -1;

    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < M; ++j) {
        if (map[i][j] == 0) {
          System.out.println(-1);
          return;
        }

        ret = Math.max(map[i][j], ret);
      }
    }

    System.out.println(ret - 1);
  }
}
