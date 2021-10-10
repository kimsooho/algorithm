
/**
 * @author suho kim
 * @no 15654
 * @title N과 M (5)
 * @url https://www.acmicpc.net/problem/15654
 * @date 2021.10.10
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int M;

  static int[] arr;
  static boolean[] visited;
  static int[] nums;

  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    sb = new StringBuilder();

    nums = new int[N];
    visited = new boolean[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; ++i) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(nums);

    arr = new int[M];
    run(0);
    System.out.println(sb);
  }

  private static void run(int count) {
    if (count == M) {
      for (int n : arr) {
        sb.append(n + " ");
      }
      sb.append('\n');
      return;
    }

    for (int i = 0; i < N; ++i) {
      if (!visited[i]) {
        visited[i] = true;
        arr[count] = nums[i];

        run(count + 1);
        visited[i] = false;
      }
    }
  }
}
