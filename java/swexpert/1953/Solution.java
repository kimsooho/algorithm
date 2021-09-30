
/**
* @author suho kim
* @no 1953
* @title 탈주범 검거
* @date 2021.09.30
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
  int pipeType;

  public Info(int row, int col, int moveCount, int pipeType) {
    this.row = row;
    this.col = col;
    this.moveCount = moveCount;
    this.pipeType = pipeType;
  }
}

public class Solution {
  static int[][] moveRow = { {}, { -1, 1, 0, 0 }, { -1, 1 }, { 0, 0 }, { -1, 0 }, { 1, 0 }, { 1, 0 }, { -1, 0 } };
  static int[][] moveCol = { {}, { 0, 0, -1, 1 }, { 0, 0 }, { -1, 1 }, { 0, 1 }, { 0, 1 }, { 0, -1 }, { 0, -1 } };

  static int[][] map;

  static int N;
  static int M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine().trim());
    for (int t = 1; t <= T; ++t) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      Info info = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1, 0);
      int moveLimit = Integer.parseInt(st.nextToken());

      map = new int[N][M];
      for (int i = 0; i < N; ++i) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; ++j) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      info.pipeType = map[info.row][info.col];
      System.out.println(String.format("#%d %d", t, run(info, moveLimit)));
    }
  }

  private static int run(Info start, int moveLimit) {
    Queue<Info> q = new LinkedList<Info>();
    q.offer(start);

    int count = 0;
    while (!q.isEmpty()) {
      Info info = q.poll();

      for (int i = 0; i < moveRow[info.pipeType].length; ++i) {
        int nextRow = info.row + moveRow[info.pipeType][i];
        int nextCol = info.col + moveCol[info.pipeType][i];

        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M || map[nextRow][nextCol] == 0
            || info.moveCount == moveLimit || !isMoveable(info.row, info.col, nextRow, nextCol, map[nextRow][nextCol]))
          continue;

        q.offer(new Info(nextRow, nextCol, info.moveCount + 1, map[nextRow][nextCol]));
        map[nextRow][nextCol] = 0;
        ++count;
      }

    }

    return count == 0 ? 1 : count;
  }

  private static boolean isMoveable(int prevRow, int prevCol, int row, int col, int pipeType) {

    for (int i = 0; i < moveRow[pipeType].length; ++i) {
      int nextRow = row + moveRow[pipeType][i];
      int nextCol = col + moveCol[pipeType][i];

      if (nextRow == prevRow && nextCol == prevCol)
        return true;
    }
    return false;
  }
}
