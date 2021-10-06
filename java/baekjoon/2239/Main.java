
/**
 * @author suho kim
 * @no 2239
 * @title 스도쿠
 * @url https://www.acmicpc.net/problem/2239
 * @date 2021.10.06
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int[][] map;
  static boolean isFinished;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    map = new int[9][9];
    for (int i = 0; i < 9; ++i) {
      String line = br.readLine();
      for (int j = 0; j < 9; ++j) {
        map[i][j] = line.charAt(j) - '0';
      }
    }

    isFinished = false;
    dfs(0);

    for (int i = 0; i < 9; ++i) {
      for (int j = 0; j < 9; ++j) {
        System.out.print(map[i][j]);
      }
      System.out.println();
    }
  }

  private static void dfs(int count) {
    if (count == 81) {
      isFinished = true;
      return;
    }

    int row = count / 9;
    int col = count % 9;

    if (map[row][col] == 0) {
      for (int i = 1; i <= 9; ++i) {
        if (isValid(row, col, i)) {
          map[row][col] = i;
          dfs(count + 1);
          if (isFinished)
            return;
          map[row][col] = 0;
        }
      }
    } else {
      dfs(count + 1);
    }
  }

  private static boolean isValid(int row, int col, int num) {
    for (int i = 0; i < 9; ++i) {
      if (map[row][i] == num || map[i][col] == num)
        return false;
    }

    int squareRow = row / 3 * 3;
    int squareCol = col / 3 * 3;

    for (int i = squareRow; i < squareRow + 3; ++i) {
      for (int j = squareCol; j < squareCol + 3; ++j) {
        if (map[i][j] == num)
          return false;
      }
    }
    return true;
  }
}
