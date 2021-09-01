
/**
 * @author suho kim
 * @no 15684
 * @title 사다리 조작
 * @url https://www.acmicpc.net/problem/15684
 * @date 2021.09.01
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int result;
  static int[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());

    map = new int[H + 1][N + 1];

    for (int i = 0; i < M; ++i) {
      st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());

      map[y][x] = 1;
      map[y][x + 1] = 2;
    }
    result = 4;
    dfs(N, H, 0, 1);
    System.out.println(result == 4 ? -1 : result);
  }

  private static void dfs(int N, int H, int count, int depth) {
    if (count == result)
      return;

    int x = 0;
    int iter = 0;
    boolean isSuccess = true;
    for (iter = 1; iter < N + 1; ++iter) {
      x = iter;
      for (int j = 1; j < H + 1; ++j) {
        if (map[j][x] == 1) {
          ++x;
        } else if (map[j][x] == 2) {
          --x;
        }
      }
      if (iter != x) {
        isSuccess = false;
        break;
      }
    }

    if (isSuccess) {
      result = count;
      return;
    }

    for (int i = depth; i < H + 1; ++i) {
      for (int j = 1; j < N; ++j) {
        if (map[i][j] == 0 && map[i][j + 1] == 0) {
          map[i][j] = 1;
          map[i][j + 1] = 2;

          dfs(N, H, count + 1, i);

          map[i][j] = 0;
          map[i][j + 1] = 0;
        }
      }
    }
  }
}
