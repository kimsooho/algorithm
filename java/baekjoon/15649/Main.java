
/**
 * @author suho kim
 * @no 15649
 * @title N과 M (1)
 * @url https://www.acmicpc.net/problem/15649
 * @date 2021.08.28
 */
import java.util.Scanner;

public class Main {
  static StringBuilder sb;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    sb = new StringBuilder();
    int N = Integer.parseInt(sc.next());
    int M = Integer.parseInt(sc.next());
    int[] arr = new int[N];
    for (int i = 0; i < N; ++i) {
      arr[i] = i + 1;
    }
    boolean[] selected = new boolean[N];

    int[] output = new int[M];

    permutation(arr, output, selected, 0, N, M);
    System.out.print(sb);
  }

  private static void permutation(int[] original, int[] output, boolean[] visited, int depth, int n, int r) {
    if (depth == r) {
      for (int num : output) {
        sb.append(num + " ");
      }
      sb.append('\n');
      return;
    }
    for (int i = 0; i < n; ++i) {
      if (!visited[i]) {
        visited[i] = true;
        output[depth] = original[i];
        permutation(original, output, visited, depth + 1, n, r);
        visited[i] = false;
      }
    }
  }
}
