
/**
 * @author suho kim
 * @no 2167
 * @title 2차원 배열의 합
 * @url https://www.acmicpc.net/problem/2167
 * @date 2021.08.22
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
    int M = Integer.parseInt(st.nextToken());

    int[][] table = new int[N][M];

    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; ++j) {
        table[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    int K = Integer.parseInt(st.nextToken());

    for (int k = 0; k < K; ++k) {
      st = new StringTokenizer(br.readLine());
      int I = Integer.parseInt(st.nextToken()) - 1;
      int J = Integer.parseInt(st.nextToken()) - 1;
      int X = Integer.parseInt(st.nextToken()) - 1;
      int Y = Integer.parseInt(st.nextToken()) - 1;

      int sum = 0;
      for (int i = I; i <= X; ++i) {
        for (int j = J; j <= Y; ++j) {
          sum += table[i][j];
        }
      }
      System.out.println(sum);
    }
  }
}
