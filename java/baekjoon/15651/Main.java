
/**
 * @author suho kim
 * @no 15651
 * @title N과 M (3)
 * @url https://www.acmicpc.net/problem/15651
 * @date 2021.10.16
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int M;

  static int[] arr;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[M];
    sb = new StringBuilder();
    run(0);
    System.out.print(sb.toString());
  }

  private static void run(int count) {
    if (count == M) {
      for (int n : arr) {
        sb.append(n).append(" ");
      }
      sb.append('\n');
      return;
    }

    for (int i = 1; i <= N; ++i) {
      arr[count] = i;
      run(count + 1);
    }
  }
}
