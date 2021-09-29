
/**
 * @author suho kim
 * @no 2448
 * @title 별 찍기 - 11
 * @url https://www.acmicpc.net/problem/2448
 * @date 2021.09.28
 */

import java.util.Scanner;

public class Main {
  static char[][] panel;

  static int N;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    panel = new char[N][N * 2];

    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N * 2 - 1; ++j) {
        panel[i][j] = ' ';
      }
    }

    division(0, N - 1, N);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N * 2 - 1; ++j) {
        sb.append(panel[i][j]);
      }
      sb.append('\n');
    }

    System.out.print(sb);
  }

  private static void paint(int row, int col) {
    panel[row][col] = '*';
    panel[row + 1][col + 1] = '*';
    panel[row + 1][col - 1] = '*';
    for (int i = 0; i < 5; ++i) {
      panel[row + 2][col + i - 2] = '*';
    }
  }

  private static void division(int row, int col, int n) {
    if (n == 3) {
      paint(row, col);
      return;
    }
    n /= 2;
    division(row, col, n);
    division(row + n, col - n, n);
    division(row + n, col + n, n);
  }
}
