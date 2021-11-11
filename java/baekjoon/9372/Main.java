
/**
 * @author suho kim
 * @no 9372
 * @title 상근이의 여행
 * @url https://www.acmicpc.net/problem/9372
 * @date 2021.11.11
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());
    while (T-- > 0) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      for (int i = 0; i < M; ++i) {
        br.readLine();
      }

      System.out.println(N - 1);
    }
  }
}
