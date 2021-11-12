
/**
 * @author suho kim
 * @no 1613
 * @title 역사
 * @url https://www.acmicpc.net/problem/1613
 * @date 2021.11.12
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[][] map = new int[N + 1][N + 1];

    for (int i = 1; i <= N; ++i) {
      for (int j = 1; j <= N; ++j) {
        map[i][j] = Integer.MAX_VALUE / 2;
      }
    }
    for (int i = 0; i < K; ++i) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());

      map[from][to] = 1;
    }

    for (int via = 1; via <= N; ++via) {
      for (int from = 1; from <= N; ++from) {
        for (int to = 1; to <= N; ++to) {
          map[from][to] = Math.min(map[from][to], map[from][via] + map[via][to]);
        }
      }
    }

    int S = Integer.parseInt(br.readLine().trim());

    for (int i = 0; i < S; ++i) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());

      if (map[A][B] == Integer.MAX_VALUE / 2 && map[B][A] == Integer.MAX_VALUE / 2)
        System.out.println(0);
      else if (map[A][B] < map[B][A]) {
        System.out.println(-1);
      } else {
        System.out.println(1);
      }

    }
  }
}
