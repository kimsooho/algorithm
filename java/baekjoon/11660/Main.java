
/**
 * @author suho kim
 * @no 11660
 * @title 구간 합 구하기 5
 * @url https://www.acmicpc.net/problem/11660
 * @date 2022.01.12
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] memo = new int[N + 1][N + 1];

    for (int i = 1; i <= N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; ++j) {
        int val = Integer.parseInt(st.nextToken());
        memo[i][j] = val + memo[i - 1][j] + memo[i][j - 1] - memo[i - 1][j - 1];
      }
    }

    for (int i = 0; i < M; ++i) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      int retValue = memo[x2][y2] - memo[x1 - 1][y2] - memo[x2][y1 - 1] + memo[x1 - 1][y1 - 1];
      System.out.println(retValue);
    }
  }
}
