
/**
 * @author suho kim
 * @no 15961
 * @title 회전 초밥
 * @url https://www.acmicpc.net/problem/15961
 * @date 2021.10.06
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
    int d = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int[] belt = new int[N];
    int[] kind = new int[d + 1];

    int kindCount = 0;

    int result = 0;
    for (int i = 0; i < N; ++i) {
      belt[i] = Integer.parseInt(br.readLine());
    }

    for (int i = 0; i < k; ++i) {
      if (kind[belt[i]] == 0) {
        ++kindCount;
      }
      ++kind[belt[i]];
    }

    result = kindCount + (kind[c] == 0 ? 1 : 0);

    for (int i = 1; i < N; ++i) {
      --kind[belt[i - 1]];
      if (kind[belt[i - 1]] == 0) {
        --kindCount;
      }

      if (kind[belt[(i + k - 1) % N]] == 0) {
        ++kindCount;
      }
      ++kind[belt[(i + k - 1) % N]];

      result = Math.max(result, kindCount + (kind[c] == 0 ? 1 : 0));
    }

    System.out.println(result);
  }
}
