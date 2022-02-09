
/**
 * @author suho kim
 * @no 16197
 * @title 두 동전
 * @url https://www.acmicpc.net/problem/16197
 * @date 2022.02.09
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Point {
  int row;
  int col;
  int moveCount = 0;

  public Point(int row, int col) {
    this.row = row;
    this.col = col;
  }

  public Point(int row, int col, int moveCount) {
    this.row = row;
    this.col = col;
    this.moveCount = moveCount;
  }
}

public class Main {
  static String[][] map;
  static List<Point> list;
  static int N;
  static int M;

  static int[] moveRow = { 1, -1, 0, 0 };
  static int[] moveCol = { 0, 0, -1, 1 };

  static boolean[][][] visited;

  static int result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new String[N][M];

    result = Integer.MAX_VALUE;
    list = new ArrayList<Point>();

    for (int i = 0; i < N; ++i) {
      String input = br.readLine();
      String[] spilit = input.split("");
      for (int j = 0; j < M; ++j) {
        map[i][j] = spilit[j];
        if (map[i][j].equals("o")) {
          list.add(new Point(i, j));
        }
      }
    }
    rec(1, list.toArray(new Point[2]));
    System.out.println(result == Integer.MAX_VALUE ? -1 : result);
  }

  private static void rec(int moveCount, Point[] points) {
    if (moveCount > 10) {
      return;
    }

    for (int i = 0; i < 4; ++i) {
      boolean[] moveable = new boolean[2];
      boolean[] isFinished = new boolean[2];

      Point[] mPoints = new Point[2];

      for (int j = 0; j < 2; ++j) {
        Point point = points[j];
        Point mPoint = new Point(point.row, point.col);
        int nextRow = point.row + moveRow[i];
        int nextCol = point.col + moveCol[i];
        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) {
          isFinished[j] = true;
        } else if (!map[nextRow][nextCol].equals("#")) {
          moveable[j] = true;

          mPoint.row = nextRow;
          mPoint.col = nextCol;
        }

        mPoints[j] = mPoint;
      }

      if (isFinished[0] && isFinished[1]) {
        continue;
      }

      if (isFinished[0] || isFinished[1]) {
        result = Math.min(result, moveCount);
        continue;
      }

      if (moveable[0] || moveable[1]) {
        rec(moveCount + 1, mPoints);
      }
    }
  }
}
