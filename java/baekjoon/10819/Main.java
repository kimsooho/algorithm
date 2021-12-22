
/**
 * @author suho kim
 * @no 10819
 * @title 차이를 최대로
 * @url https://www.acmicpc.net/problem/10819
 * @date 2021.12.22
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static boolean[] visited;
  static int[] output;
  static int[] nums;

  static int result = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    visited = new boolean[N];
    output = new int[N];
    nums = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; ++i) {
      nums[i] = Integer.parseInt(st.nextToken());
    }
    per(0);
    System.out.println(result);
  }

  private static void per(int depth) {
    if (depth == N) {
      result = Math.max(result, cal());
      return;
    }

    for (int i = 0; i < N; ++i) {
      if (!visited[i]) {
        visited[i] = true;
        output[depth] = i;
        per(depth + 1);
        visited[i] = false;
      }
    }
  }

  private static int cal() {
    int retValue = 0;

    for (int i = 0; i < N - 1; ++i) {
      retValue += Math.abs(nums[output[i]] - nums[output[i + 1]]);
    }

    return retValue;
  }
}
