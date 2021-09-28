
/**
* @author suho kim
* @no 5607
* @title 조합
* @date 2021.09.28
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  static long MOD = 1234567891;
  static int MAX = 1000000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());

    long[] memo = new long[MAX + 1];
    memo[0] = memo[1] = 1;

    for (int i = 2; i <= MAX; ++i) {
      memo[i] = (memo[i - 1] * i) % MOD;
    }

    for (int t = 1; t <= T; ++t) {
      long result = 0;

      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int R = Integer.parseInt(st.nextToken());

      long tmp = fermat((memo[R] * memo[N - R]) % MOD, MOD - 2);
      result = memo[N] * tmp % MOD;

      System.out.println(String.format("#%d %d", t, result));
    }
  }

  private static long fermat(long num, long mod) {
    if (mod == 0)
      return 1;

    long tmp = fermat(num, mod / 2);
    long retValue = tmp * tmp % MOD;

    if (mod % 2 == 0)
      return retValue;

    return (num * retValue) % MOD;
  }
}
