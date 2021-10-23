
/**
 * @author suho kim
 * @no 2580
 * @title 스도쿠
 * @url https://www.acmicpc.net/problem/2580
 * @date 2021.10.23
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] map;
  static int N;
  static boolean isFinished;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = 9;
    map = new int[N][N];

    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    isFinished = false;
    run(0);
  }

  private static void run(int depth) {
    if (depth == N * N) {
      if (!isFinished) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; ++i) {
          for (int j = 0; j < N; ++j) {
            sb.append(map[i][j] + " ");
          }
          sb.append("\n");
        }
        System.out.print(sb);
        isFinished = true;
      }
      return;
    }

    int row = depth / N;
    int col = depth % N;
    if (map[row][col] == 0) {
      for (int n = 1; n <= N; ++n) {
        if (isValid(row, col, n)) {
          map[row][col] = n;
          run(depth + 1);
          map[row][col] = 0;
        }
      }
    } else {
      run(depth + 1);
    }
  }

  private static boolean isValid(int row, int col, int val) {

    for (int i = 0; i < N; ++i) {
      if (map[row][i] == val || map[i][col] == val)
        return false;
    }
    int r = row / 3 * 3;
    int c = col / 3 * 3;
    for (int i = r; i < r + 3; ++i) {
      for (int j = c; j < c + 3; ++j) {
        if (map[i][j] == val) {
          return false;
        }
      }
    }
    return true;
  }
}
