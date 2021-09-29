
/**
 * @author suho kim
 * @no 1194
 * @title 달이 차오른다, 가자.
 * @url https://www.acmicpc.net/problem/1194
 * @date 2021.09.29
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Info {
  int row;
  int col;
  int key;
  int move;

  public Info(int row, int col, int key, int move) {
    this.row = row;
    this.col = col;
    this.key = key;
    this.move = move;
  }
}

public class Main {
  static int[] moveRow = { -1, 1, 0, 0 };
  static int[] moveCol = { 0, 0, -1, 1 };

  static char[][] maze;
  static boolean[][][] visited;

  static int N;
  static int M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    maze = new char[N][M];
    visited = new boolean[64][N][M];

    Info start = null;
    for (int i = 0; i < N; ++i) {
      String[] split = br.readLine().split("");
      for (int j = 0; j < M; ++j) {
        maze[i][j] = split[j].charAt(0);
        if (maze[i][j] == '0') {
          start = new Info(i, j, 0, 0);
        }
      }
    }

    System.out.println(run(start));
  }

  private static int run(Info start) {
    Queue<Info> q = new LinkedList<Info>();
    q.offer(start);
    visited[start.key][start.row][start.col] = true;

    while (!q.isEmpty()) {
      Info info = q.poll();

      for (int i = 0; i < 4; ++i) {
        int nextRow = info.row + moveRow[i];
        int nextCol = info.col + moveCol[i];
        int key = info.key;
        int move = info.move + 1;

        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M || visited[key][nextRow][nextCol]
            || maze[nextRow][nextCol] == '#')
          continue;

        char value = maze[nextRow][nextCol];

        if (value == '1') {
          return move;
        } else if ('a' <= value && value <= 'f') {
          key |= 1 << value - 'a';
        } else if ('A' <= value && value <= 'F') {
          if ((key & 1 << value - 'A') == 0)
            continue;
        }
        visited[key][nextRow][nextCol] = true;

        q.offer(new Info(nextRow, nextCol, key, move));
      }
    }
    return -1;
  }
}
