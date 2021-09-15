
/**
 * @author suho kim
 * @no 2206
 * @title 벽 부수고 이동하기
 * @url https://www.acmicpc.net/problem/2206
 * @date 2021.09.15
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Info {
  int row;
  int col;
  int moveCount;
  int isDestroyed;

  public Info(int row, int col, int moveCount, int isDestroyed) {
    this.row = row;
    this.col = col;
    this.moveCount = moveCount;
    this.isDestroyed = isDestroyed;
  }
}

public class Main {
  static boolean[][][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] map = new int[N][M];
    visited = new boolean[2][N][M];
    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      String line = st.nextToken();
      for (int j = 0; j < M; ++j) {
        map[i][j] = line.charAt(j) - '0';
      }
    }
    int moveCount = bfs(map);
    System.out.println(moveCount == 0 ? -1 : moveCount);
  }

  public static int bfs(int[][] map) {
    int[] moveRow = { -1, 1, 0, 0 };
    int[] moveCol = { 0, 0, -1, 1 };

    Queue<Info> q = new LinkedList<Info>();

    q.offer(new Info(0, 0, 1, map[0][0]));
    visited[map[0][0]][0][0] = true;

    while (!q.isEmpty()) {
      Info info = q.poll();

      if (info.row == map.length - 1 && info.col == map[0].length - 1) {
        return info.moveCount;
      }
      for (int i = 0; i < 4; ++i) {
        int nextRow = info.row + moveRow[i];
        int nextCol = info.col + moveCol[i];

        if (nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[0].length)
          continue;

        if (map[nextRow][nextCol] == 1 && info.isDestroyed == 0) {
          visited[1][nextRow][nextCol] = true;
          q.offer(new Info(nextRow, nextCol, info.moveCount + 1, 1));
        } else if (map[nextRow][nextCol] == 0 && !visited[info.isDestroyed][nextRow][nextCol]) {
          visited[info.isDestroyed][nextRow][nextCol] = true;
          q.offer(new Info(nextRow, nextCol, info.moveCount + 1, info.isDestroyed));
        }
      }
    }
    return -1;
  }
}
