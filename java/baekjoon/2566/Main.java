
/**
 * @author suho kim
 * @no 2566
 * @title 최댓값
 * @url https://www.acmicpc.net/problem/2566
 * @date 2021.09.11
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int r = 0;
    int c = 0;
    int max = 0;

    for (int i = 0; i < 9; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 9; ++j) {
        int num = Integer.parseInt(st.nextToken());
        if (max < num) {
          max = num;
          r = i + 1;
          c = j + 1;
        }
      }
    }

    System.out.println(String.format("%d\n%d %d", max, r, c));

  }
}
