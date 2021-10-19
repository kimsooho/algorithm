
/**
 * @author suho kim
 * @no 9663
 * @title N-Queen
 * @url https://www.acmicpc.net/problem/9663
 * @date 2021.10.19
 */
import java.util.Scanner;

public class Main {
  static int[] col;

  static int ret;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    col = new int[N];

    ret = 0;
    dfs(0, N);
    System.out.println(ret);
  }

  private static void dfs(int depth, int N) {
    if (depth == N) {
      ++ret;
      return;
    }

    for (int i = 0; i < N; ++i) {
      col[depth] = i;
      if (isValid(depth))
        dfs(depth + 1, N);
    }
  }

  private static boolean isValid(int idx) {
    for (int i = 0; i < idx; ++i) {
      if (col[i] == col[idx] || Math.abs(col[i] - col[idx]) == Math.abs(idx - i))
        return false;
    }

    return true;
  }
}
