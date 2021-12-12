
/**
 * @author suho kim
 * @no 18405
 * @title 경쟁적 전염
 * @url https://www.acmicpc.net/problem/18405
 * @date 2021.12.12
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Info implements Comparable<Info> {
  int row;
  int col;
  int value;

  public Info(int row, int col, int value) {
    this.row = row;
    this.col = col;
    this.value = value;
  }

  @Override
  public int compareTo(Info o) {
    return this.value - o.value;
  }
}

public class Main {
  static PriorityQueue<Info> pq;
  static int[][] map;
  static boolean[][] visited;

  static int N;

  static int[] moveRow = { -1, 1, 0, 0 };
  static int[] moveCol = { 0, 0, -1, 1 };

  public static void main(String[] args) throws IOException {
    pq = new PriorityQueue<Info>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    map = new int[N + 1][N + 1];
    visited = new boolean[N + 1][N + 1];

    for (int i = 1; i <= N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());

        if (map[i][j] != 0) {
          pq.offer(new Info(i, j, map[i][j]));
          visited[i][j] = true;
        }
      }
    }

    st = new StringTokenizer(br.readLine());
    int S = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());
    int Y = Integer.parseInt(st.nextToken());

    int time = 0;
    while (time++ != S && !pq.isEmpty()) {
      spread();
    }

    System.out.println(map[X][Y]);
  }

  private static void spread() {
    PriorityQueue<Info> _pq = new PriorityQueue<Info>(pq);
    pq.clear();

    while (!_pq.isEmpty()) {
      Info info = _pq.poll();

      for (int i = 0; i < 4; ++i) {
        int nextRow = info.row + moveRow[i];
        int nextCol = info.col + moveCol[i];

        if (nextRow < 1 || nextRow > N || nextCol < 1 || nextCol > N || visited[nextRow][nextCol])
          continue;

        visited[nextRow][nextCol] = true;
        map[nextRow][nextCol] = info.value;
        pq.offer(new Info(nextRow, nextCol, info.value));
      }
    }
  }
}
