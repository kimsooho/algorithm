
/**
 * @author suho kim
 * @no 1600
 * @title 말이 되고픈 원숭이
 * @url https://www.acmicpc.net/problem/1600
 * @date 2021.09.15
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Monkey {
  int row;
  int col;
  int horseCount;

  public Monkey(int row, int col, int horseCount) {
    this.row = row;
    this.col = col;
    this.horseCount = horseCount;
  }
}

public class Main {
  static int[] moveRow = { -1, 1, 0, 0, -1, -2, 1, 2, -1, -2, 1, 2 };
  static int[] moveCol = { 0, 0, -1, 1, -2, -1, -2, -1, 2, 1, 2, 1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int K = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int W = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());
    int[][] map = new int[H][W];
    int[][][] visited = new int[H][W][K + 1];

    for (int i = 0; i < H; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < W; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    System.out.println(run(map, visited, K));
  }

  private static int run(int[][] map, int[][][] visited, int k) {
    Queue<Monkey> q = new LinkedList<Monkey>();
    q.offer(new Monkey(0, 0, 0));
    visited[0][0][0] = 1;
    while (!q.isEmpty()) {
      Monkey monkey = q.poll();

      if (monkey.row == map.length - 1 && monkey.col == map[0].length - 1) {
        return visited[monkey.row][monkey.col][monkey.horseCount] - 1;
      }
      for (int i = 0; i < 12; ++i) {
        int nextRow = monkey.row + moveRow[i];
        int nextCol = monkey.col + moveCol[i];

        if (nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[0].length
            || map[nextRow][nextCol] == 1)
          continue;

        int horseCount = monkey.horseCount;
        if (i >= 4) {
          if (monkey.horseCount == k)
            break;
          ++horseCount;
        }
        if (visited[nextRow][nextCol][horseCount] == 0) {
          visited[nextRow][nextCol][horseCount] = visited[monkey.row][monkey.col][monkey.horseCount] + 1;
          q.offer(new Monkey(nextRow, nextCol, horseCount));
        }
      }
    }
    return -1;
  }
}
