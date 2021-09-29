
/**
 * @author suho kim
 * @no 4485
 * @title 녹색 옷 입은 애가 젤다지?
 * @url https://www.acmicpc.net/problem/4485
 * @date 2021.09.29
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pair {
  int row;
  int col;

  public Pair(int row, int col) {
    this.row = row;
    this.col = col;
  }
}

class Info implements Comparable<Info> {
  Pair pos;
  int cost;

  public Info(Pair pos, int cost) {
    this.pos = pos;
    this.cost = cost;
  }

  @Override
  public int compareTo(Info o) {
    return this.cost - o.cost;
  }
}

public class Main {
  static int[] moveRow = { -1, 1, 0, 0 };
  static int[] moveCol = { 0, 0, -1, 1 };

  static int[][] map;
  static int[][] cost;

  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int testCase = 0;
    while (true) {
      N = Integer.parseInt(br.readLine());
      if (N == 0)
        break;

      map = new int[N][N];
      cost = new int[N][N];

      for (int i = 0; i < N; ++i) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; ++j) {
          map[i][j] = Integer.parseInt(st.nextToken());
          cost[i][j] = Integer.MAX_VALUE;
        }
      }
      System.out.println(String.format("Problem %d: %d", ++testCase, run()));

    }
  }

  private static int run() {
    PriorityQueue<Info> pq = new PriorityQueue<Info>();
    pq.offer(new Info(new Pair(0, 0), map[0][0]));
    cost[0][0] = map[0][0];
    while (!pq.isEmpty()) {
      Info info = pq.poll();

      for (int i = 0; i < 4; ++i) {
        int nextRow = info.pos.row + moveRow[i];
        int nextCol = info.pos.col + moveCol[i];
        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N
            || cost[nextRow][nextCol] <= cost[info.pos.row][info.pos.col] + map[nextRow][nextCol])
          continue;

        int _cost = cost[info.pos.row][info.pos.col] + map[nextRow][nextCol];
        pq.offer(new Info(new Pair(nextRow, nextCol), _cost));
        cost[nextRow][nextCol] = _cost;
      }
    }

    return cost[N - 1][N - 1];
  }
}
