
/**
 * @author suho kim
 * @no  14502
 * @title 연구소
 * @url https://www.acmicpc.net/problem/14502
 * @date 2021.08.21
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
  static int N;
  static int M;

  static int[][] map;
  static Queue<Pair> q;
  static int result = 0;

  static int[] moveRow = { 0, 0, -1, 1 };
  static int[] moveCol = { -1, 1, 0, 0 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    q = new LinkedList<Pair>();
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 2) {
          q.add(new Pair(i, j));
        }
      }
    }

    dfs(0);
    System.out.println(result);
  }

  private static void dfs(int count) {
    if (count == 3) {
      bfs();
      return;
    }

    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < M; ++j) {
        if (map[i][j] == 0) {
          map[i][j] = 1;
          dfs(count + 1);
          map[i][j] = 0;
        }
      }
    }
  }

  private static void bfs() {
    int[][] _map = new int[N][M];
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < M; ++j) {
        _map[i][j] = map[i][j];
      }
    }

    Queue<Pair> _q = new LinkedList<Pair>(q);
    while (!_q.isEmpty()) {
      Pair pair = _q.poll();

      for (int i = 0; i < 4; ++i) {
        int nextRow = pair.row + moveRow[i];
        int nextCol = pair.col + moveCol[i];

        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M || _map[nextRow][nextCol] != 0)
          continue;

        _map[nextRow][nextCol] = 2;
        _q.offer(new Pair(nextRow, nextCol));
      }
    }

    int count = 0;
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < M; ++j) {
        if (_map[i][j] == 0)
          ++count;
      }
    }

    result = Math.max(result, count);
  }
}
