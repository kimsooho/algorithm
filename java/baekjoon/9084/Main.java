
/**
 * @author suho kim
 * @no 9084
 * @title 동전
 * @url https://www.acmicpc.net/problem/9084
 * @date 2022.03.23
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());
    while (T-- > 0) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int[] arr = new int[N];

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; ++i) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      st = new StringTokenizer(br.readLine());
      int M = Integer.parseInt(st.nextToken());

      int[] memo = new int[M + 1];
      memo[0] = 1;
      for (int val : arr) {
        for (int i = val; i <= M; ++i) {
          memo[i] += memo[i - val];
        }
      }

      System.out.println(memo[M]);
    }
  }
}
