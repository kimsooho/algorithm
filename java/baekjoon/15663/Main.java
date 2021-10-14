
/**
 * @author suho kim
 * @no 15663
 * @title N과 M (9)
 * @url https://www.acmicpc.net/problem/15663
 * @date 2021.10.14
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int M;

  static int[] arr;
  static boolean[] visited;
  static int[] nums;

  static LinkedHashSet<String> hash;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    nums = new int[N];
    visited = new boolean[N];
    st = new StringTokenizer(br.readLine());
    hash = new LinkedHashSet<String>();
    for (int i = 0; i < N; ++i) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(nums);

    arr = new int[M];
    run(0);
    for (String ret : hash) {
      System.out.print(ret);
    }
  }

  private static void run(int idx) {
    if (idx == M) {
      StringBuilder sb = new StringBuilder();
      for (int n : arr) {
        sb.append(n + " ");
      }
      sb.append('\n');
      hash.add(sb.toString());
      return;
    }

    for (int i = 0; i < N; ++i) {
      if (!visited[i]) {
        visited[i] = true;
        arr[idx] = nums[i];
        run(idx + 1);
        visited[i] = false;
      }
    }
  }
}
