
/**
 * @author suho kim
 * @no 1074
 * @title Z
 * @url https://www.acmicpc.net/problem/1074
 * @date 2021.08.17
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int R;
  static int C;
  static int result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    result = 0;
    Z(0, 0, 1 << N);
  }

  private static void Z(int r, int c, int size) {
    if (r == R && c == C) {
      System.out.println(result);
      return;
    }

    if (R < r + size && R >= r && C < c + size && C >= c) {
      int harf = size / 2;
      Z(r, c, harf);
      Z(r, c + harf, harf);
      Z(r + harf, c, harf);
      Z(r + harf, c + harf, harf);
    } else {
      result += size * size;
    }
  }
}