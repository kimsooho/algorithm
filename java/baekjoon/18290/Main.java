
/**
 * @author suho kim
 * @no 18290
 * @title NM과 K (1)
 * @url https://www.acmicpc.net/problem/18290
 * @date 2022.02.22
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int M;

  static int result = Integer.MIN_VALUE;
  static int[][] map;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    rec(K, 0, 0, 0, 0);

    System.out.println(result);
  }

  private static void rec(int K, int selectedCount, int row, int col, int sum) {
    if (selectedCount == K) {
      result = Math.max(result, sum);
      return;
    }

    for (int i = row; i < N; ++i) {
      for (int j = col; j < M; ++j) {
        if ((i == 0 || !visited[i - 1][j]) && (j == 0 || !visited[i][j - 1])) {
          visited[i][j] = true;
          rec(K, selectedCount + 1, i, j + 1, sum + map[i][j]);
          visited[i][j] = false;
        }
      }
      col = 0;
    }
  }
}
