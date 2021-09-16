
/**
* @author suho kim
* @no 3307
* @title 최장 증가 부분 수열
* @date 2021.09.16
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());

    for (int t = 1; t <= T; ++t) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());

      int[] arr = new int[N];
      int[] dp = new int[N];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; ++i) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      dp[0] = 1;
      int maxValue = -1;
      for (int i = 1; i < N; ++i) {
        dp[i] = 1;
        for (int j = 0; j < i; ++j) {
          if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
            dp[i] = dp[j] + 1;
          }
        }
        if (maxValue < dp[i])
          maxValue = dp[i];
      }

      System.out.println(String.format("#%d %d", t, maxValue));
    }
  }
}
