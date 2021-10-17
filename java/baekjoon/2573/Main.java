
/**
 * @author suho kim
 * @no 2573
 * @title 빙산
 * @url https://www.acmicpc.net/problem/2573
 * @date 2021.10.17
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
  static ArrayList<Pair> ices;

  static int[] moveRow = { -1, 1, 0, 0 };
  static int[] moveCol = { 0, 0, -1, 1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    ices = new ArrayList<Pair>();
    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] != 0)
          ices.add(new Pair(i, j));
      }
    }

    System.out.println(run());
  }

  private static int run() {
    int count = -1;
    boolean isDivided = false;
    while (!isDivided) {
      if (ices.size() == 0)
        return 0;

      ++count;
      boolean[][] visited = new boolean[N][M];
      Queue<Pair> q = new LinkedList<Pair>();
      q.offer(ices.get(0));
      visited[ices.get(0).row][ices.get(0).col] = true;
      while (!q.isEmpty()) {
        Pair pair = q.poll();

        for (int i = 0; i < 4; ++i) {
          int nextRow = pair.row + moveRow[i];
          int nextCol = pair.col + moveCol[i];

          if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M || visited[nextRow][nextCol])
            continue;

          if (map[nextRow][nextCol] == 0 && map[pair.row][pair.col] != 0) {
            --map[pair.row][pair.col];
          } else if (map[nextRow][nextCol] != 0) {
            visited[nextRow][nextCol] = true;
            q.offer(new Pair(nextRow, nextCol));
          }
        }
      }

      int size = ices.size();
      for (int i = size - 1; i >= 0; --i) {
        Pair pair = ices.get(i);
        if (!visited[pair.row][pair.col]) {
          isDivided = true;
        }

        if (map[pair.row][pair.col] == 0) {
          ices.remove(pair);
        }
      }
    }

    return count;
  }
}
