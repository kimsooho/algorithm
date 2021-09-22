
/**
 * @author suho kim
 * @no 2210
 * @title 숫자판 점프
 * @url https://www.acmicpc.net/problem/2210
 * @date 2021.09.22
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
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

  static HashSet<String> hash;

  static int[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    map = new int[5][5];
    hash = new HashSet<String>();

    for (int i = 0; i < 5; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < 5; ++i) {
      for (int j = 0; j < 5; ++j) {
        dfs(new Pair(i, j), String.valueOf(map[i][j]));
      }
    }

    System.out.println(hash.size());
  }

  private static void dfs(Pair pair, String num) {
    if (num.length() == 6) {
      hash.add(num);
      return;
    }
    for (int i = 0; i < 4; ++i) {
      int nextRow = pair.row + moveRow[i];
      int nextCol = pair.col + moveCol[i];

      if (nextRow < 0 || nextRow >= 5 || nextCol < 0 || nextCol >= 5)
        continue;

      dfs(new Pair(nextRow, nextCol), num + String.valueOf(map[nextRow][nextCol]));
    }
  }
}