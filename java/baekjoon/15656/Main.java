
/**
 * @author suho kim
 * @no 15656
 * @title N과 M (7)
 * @url https://www.acmicpc.net/problem/15656
 * @date 2021.11.14
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int[] output;
  static int[] arr;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    sb = new StringBuilder();
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    arr = new int[N];
    output = new int[M];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    run(0, N, M);

    System.out.print(sb);
  }

  private static void run(int depth, int N, int M) {
    if (depth == M) {
      for (int num : output) {
        sb.append(num + " ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 0; i < N; ++i) {
      output[depth] = arr[i];
      run(depth + 1, N, M);
    }
  }
}
