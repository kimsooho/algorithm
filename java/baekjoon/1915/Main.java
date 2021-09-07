
/**
 * @author suho kim
 * @no 1915
 * @title 가장 큰 정사각형
 * @url https://www.acmicpc.net/problem/1915
 * @date 2021.09.08
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] map = new int[n][m];

    int maxValue = 0;
    for (int i = 0; i < n; ++i) {
      String line = br.readLine();

      for (int j = 0; j < m; ++j) {
        map[i][j] = line.charAt(j) - '0';
        if (map[i][j] == 1)
          maxValue = 1;
      }
    }

    for (int i = 1; i < n; ++i) {
      for (int j = 1; j < m; ++j) {
        if (map[i][j] == 1) {
          map[i][j] = Math.min(map[i - 1][j - 1], Math.min(map[i - 1][j], map[i][j - 1])) + 1;
          maxValue = Math.max(maxValue, map[i][j]);
        }
      }
    }

    System.out.println(maxValue * maxValue);
  }
}
