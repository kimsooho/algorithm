
/**
 * @author suho kim
 * @no 1929
 * @title 소수 구하기
 * @url https://www.acmicpc.net/problem/3109 
 * @date 2021.09.23
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    for (int i = M; i <= N; ++i) {
      if (i < 2)
        continue;
      if (i == 2) {
        System.out.println(i);
        continue;
      }

      boolean isPrime = true;

      for (int j = 2; j <= Math.sqrt(i); ++j) {
        if (i % j == 0) {
          isPrime = false;
          break;
        }
      }

      if (isPrime) {
        System.out.println(i);
      }
    }
  }
}
