
/**
 * @author suho kim
 * @no 17171
 * @title 연구소 2
 * @url https://www.acmicpc.net/problem/17141
 * @date 2021.12.01
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
  static int N;
  static int M;

  static int[][] map;
  static int[] moveRow = { -1, 1, 0, 0 };
  static int[] moveCol = { 0, 0, -1, 1 };

  static boolean[] isSelected;
  static Pair[] selectedPosition;

  static boolean[][] visited;

  static List<Pair> positions;

  static int retValue = Integer.MAX_VALUE / 2;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][N];
    positions = new ArrayList<Pair>();
    selectedPosition = new Pair[M];

    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 2) {
          positions.add(new Pair(i, j));
        }
      }
    }

    isSelected = new boolean[positions.size()];

    Sol();
    System.out.println(retValue == Integer.MAX_VALUE / 2 ? -1 : retValue);
  }

  private static void Sol() {
    Selection(0, 0, M);
  }

  private static void Selection(int idx, int depth, int limit) {
    if (depth == limit) {
      retValue = Math.min(Vine(), retValue);
      return;
    }

    for (int i = idx; i < positions.size(); ++i) {
      if (!isSelected[i]) {
        isSelected[i] = true;
        selectedPosition[depth] = positions.get(i);
        Selection(i, depth + 1, limit);
        isSelected[i] = false;
      }
    }
  }

  private static int Vine() {
    visited = new boolean[N][N];
    Queue<Pair> q = new LinkedList<Pair>();

    for (int i = 0; i < selectedPosition.length; ++i) {
      int row = selectedPosition[i].row;
      int col = selectedPosition[i].col;
      q.offer(new Pair(row, col));
      visited[row][col] = true;
    }
    int count = -1;
    while (!q.isEmpty()) {
      int size = q.size();
      ++count;
      for (int s = 0; s < size; ++s) {
        Pair pair = q.poll();

        for (int i = 0; i < 4; ++i) {
          int nextRow = pair.row + moveRow[i];
          int nextCol = pair.col + moveCol[i];

          if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N || map[nextRow][nextCol] == 1
              || visited[nextRow][nextCol])
            continue;

          visited[nextRow][nextCol] = true;
          q.offer(new Pair(nextRow, nextCol));
        }
      }
    }

    return isValid() ? count : Integer.MAX_VALUE / 2;
  }

  private static boolean isValid() {
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        if (map[i][j] != 1 && !visited[i][j])
          return false;
      }
    }

    return true;
  }
}
