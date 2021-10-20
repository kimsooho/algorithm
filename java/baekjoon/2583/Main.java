
/**
 * @author suho kim
 * @no 2583
 * @title 영역 구하기
 * @url https://www.acmicpc.net/problem/2583
 * @date 2021.10.20
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
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
  static int[] moveRow = { -1, 1, 0, 0 };
  static int[] moveCol = { 0, 0, -1, 1 };

  static int[][] map;
  static int M;
  static int N;
  static PriorityQueue<Integer> pq;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    pq = new PriorityQueue<Integer>();
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    map = new int[M][N];

    for (int i = 0; i < K; ++i) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());

      int x2 = Integer.parseInt(st.nextToken()) - 1;
      int y2 = Integer.parseInt(st.nextToken()) - 1;

      for (int x = x1; x <= x2; ++x) {
        for (int y = y1; y <= y2; ++y) {
          map[y][x] = 1;
        }
      }
    }

    for (int i = 0; i < M; ++i) {
      for (int j = 0; j < N; ++j) {
        if (map[i][j] == 0) {
          map[i][j] = 1;
          bfs(new Pair(i, j));
        }
      }
    }

    System.out.println(pq.size());
    while (!pq.isEmpty()) {
      System.out.print(pq.poll() + " ");
    }
    System.out.println();
  }

  private static void bfs(Pair start) {
    Queue<Pair> q = new LinkedList<Pair>();
    q.offer(start);
    int count = 0;
    while (!q.isEmpty()) {
      ++count;
      Pair pair = q.poll();

      for (int i = 0; i < 4; ++i) {
        int nextRow = pair.row + moveRow[i];
        int nextCol = pair.col + moveCol[i];

        if (nextRow < 0 || nextRow >= M || nextCol < 0 || nextCol >= N || map[nextRow][nextCol] == 1)
          continue;

        map[nextRow][nextCol] = 1;
        q.offer(new Pair(nextRow, nextCol));
      }
    }

    pq.offer(count);
  }
}
