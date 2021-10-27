
/**
 * @author suho kim
 * @no 2589
 * @title 보물섬
 * @url https://www.acmicpc.net/problem/2589
 * @date 2021.10.27
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
  int step;

  public Pair(int row, int col, int step) {
    this.row = row;
    this.col = col;
    this.step = step;
  }
}

public class Main {
  static char[][] map;

  static int[] moveRow = { -1, 1, 0, 0 };
  static int[] moveCol = { 0, 0, -1, 1 };

  static ArrayList<Pair> pairs;

  static int N;
  static int M;
  static int maxVal;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new char[N][M];
    pairs = new ArrayList<Pair>();

    for (int i = 0; i < N; ++i) {
      String line = br.readLine();
      for (int j = 0; j < M; ++j) {
        map[i][j] = line.charAt(j);
        if (map[i][j] == 'L') {
          pairs.add(new Pair(i, j, 0));
        }
      }
    }

    maxVal = 0;
    for (Pair pair : pairs) {
      bfs(pair);
    }

    System.out.println(maxVal);
  }

  private static void bfs(Pair start) {
    char[][] copy = new char[N][M];
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < M; ++j) {
        copy[i][j] = map[i][j];
      }
    }

    Queue<Pair> q = new LinkedList<Pair>();
    q.offer(start);
    copy[start.row][start.col] = 'W';
    while (!q.isEmpty()) {
      Pair pair = q.poll();
      for (int i = 0; i < 4; ++i) {
        int nextRow = pair.row + moveRow[i];
        int nextCol = pair.col + moveCol[i];

        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M || copy[nextRow][nextCol] != 'L')
          continue;

        copy[nextRow][nextCol] = 'W';
        q.offer(new Pair(nextRow, nextCol, pair.step + 1));
      }

      if (q.isEmpty()) {
        maxVal = Math.max(maxVal, pair.step);
      }
    }
  }
}
