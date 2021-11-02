
/**
 * @author suho kim
 * @no 2234
 * @title 성곽
 * @url https://www.acmicpc.net/problem/2234
 * @date 2021.11.02
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

  static int[][] mapInfo;
  static int[][] map;

  static int[] moveCol = { -1, 0, 1, 0 };
  static int[] moveRow = { 0, -1, 0, 1 };

  static List<Integer> list;
  static int maxVal;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    mapInfo = new int[N][M];
    map = new int[N][M];

    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; ++j) {
        mapInfo[i][j] = Integer.parseInt(st.nextToken());
        map[i][j] = -1;
      }
    }

    list = new ArrayList<Integer>();
    maxVal = 0;

    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < M; ++j) {
        if (map[i][j] == -1) {
          bfs(new Pair(i, j));
        }
      }
    }

    int sumMaxVal = 0;
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < M; ++j) {
        sumMaxVal = Math.max(sumMaxVal, list.get(map[i][j]));

        if (i + 1 < N && map[i][j] != map[i + 1][j]) {
          sumMaxVal = Math.max(sumMaxVal, list.get(map[i][j]) + list.get(map[i + 1][j]));
        }

        if (j + 1 < M && map[i][j] != map[i][j + 1]) {
          sumMaxVal = Math.max(sumMaxVal, list.get(map[i][j]) + list.get(map[i][j + 1]));
        }
      }
    }

    System.out.println(list.size());
    System.out.println(maxVal);
    System.out.println(sumMaxVal);
  }

  private static void bfs(Pair start) {
    Queue<Pair> q = new LinkedList<Pair>();
    q.offer(start);
    int val = list.size();
    map[start.row][start.col] = val;
    int count = 0;
    while (!q.isEmpty()) {
      ++count;

      Pair pair = q.poll();
      for (int i = 0; i < 4; ++i) {
        if ((1 << i & mapInfo[pair.row][pair.col]) == 0) {
          int nextRow = pair.row + moveRow[i];
          int nextCol = pair.col + moveCol[i];
          if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M || map[nextRow][nextCol] != -1)
            continue;

          map[nextRow][nextCol] = val;
          q.offer(new Pair(nextRow, nextCol));
        }
      }
    }

    list.add(count);
    maxVal = Math.max(maxVal, count);
  }
}
