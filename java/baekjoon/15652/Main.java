
/**
 * @author suho kim
 * @no 15652
 * @title N과 M (4)
 * @url https://www.acmicpc.net/problem/15652
 * @date 2021.10.09
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int M;

  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[M];
    run(1, 0);
  }

  private static void run(int num, int count) {
    if (count == M) {
      for (int n : arr) {
        System.out.print(n + " ");
      }
      System.out.println();
      return;
    }

    for (int i = num; i <= N; ++i) {
      arr[count] = i;

      run(i, count + 1);
    }
  }
}
