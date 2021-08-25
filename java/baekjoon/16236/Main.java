/**
 * @author suho kim
 * @no 16236
 * @title 아기상어
 * @url https://www.acmicpc.net/problem/16236
 * @date 2021.08.25
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Info implements Comparable<Info> {
  int row;
  int col;
  int move;

  public Info(int row, int col, int move) {
    this.row = row;
    this.col = col;
    this.move = move;
  }

  @Override
  public int compareTo(Info o) {
    if(this.move == o.move)
    {
      if(this.row == o.row)
        return this.col - o.col;
      return this.row - o.row;
    }
    return this.move - o.move;    
  }
}

public class Main {
  static int[] moveRow = { 0, 0, -1, 1 };
  static int[] moveCol = { -1, 1, 0, 0 };
  static int[][] map;
  static boolean[] visited;

  static Queue<Info> q;

  static int N;
  static int result;
  static int size;
  static int eatCount;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    map = new int[N][N];
    q = new LinkedList<Info>();

    size = 2;
    result = 0;
    eatCount = 0;
    for (int r = 0; r < N; ++r) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < N; ++c) {
        map[r][c] = Integer.parseInt(st.nextToken());
        if (map[r][c] == 9) {
          q.offer(new Info(r, c, 0));
          map[r][c] = 0;
        }
      }
    }

    run();
    System.out.println(result);
  }

  public static void run() {    
    while (true) {
      PriorityQueue<Info> pq = new PriorityQueue<Info>();
      boolean[][] visited = new boolean[N][N];

      visited[q.peek().row][q.peek().col] = true;
      while (!q.isEmpty()) {
        Info info = q.poll();        

        for (int i = 0; i < 4; ++i) {
          int nextRow = info.row + moveRow[i];
          int nextCol = info.col + moveCol[i];

          if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N || visited[nextRow][nextCol] || map[nextRow][nextCol] > size) {
            continue;
          }

          q.offer(new Info(nextRow, nextCol, info.move + 1));
          visited[nextRow][nextCol] = true;
          if(map[nextRow][nextCol] != 0 && map[nextRow][nextCol] < size )
          {
            pq.offer(new Info(nextRow, nextCol, info.move + 1));
          }
        }
      }

      if(pq.isEmpty())
        return;

      Info info = pq.poll();

      if(++eatCount == size)
      {
        ++size;
        eatCount = 0;
      }

      map[info.row][info.col] = 0;
      q.offer(info);

      result = info.move;
    }
  }
}
