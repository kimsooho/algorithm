
/**
 * @author suho kim
 * @no 10164
 * @title 격자상의 경로
 * @url https://www.acmicpc.net/problem/10164
 * @date 2022.01.26
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
    int K = Integer.parseInt(st.nextToken());

    int[][] dp = new int[N + 1][M + 1];
    dp[0][1] = 1;

    int routeN = N;
    int routeM = M;
    if (K != 0) {
      routeN = (K - 1) / M + 1;
      routeM = (K - 1) % M + 1;
    }

    for (int i = 1; i <= routeN; ++i) {
      for (int j = 1; j <= routeM; ++j) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }

    for (int i = routeN; i <= N; ++i) {
      for (int j = routeM; j <= M; ++j) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }

    System.out.println(dp[N][M]);
  }
}
