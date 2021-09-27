
/**
 * @author suho kim
 * @no 2475
 * @title 검증수
 * @url https://www.acmicpc.net/problem/2475
 * @date 2021.09.27
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int sum = 0;
    for (int i = 0; i < 5; ++i) {
      sum += Math.pow(Integer.parseInt(st.nextToken()), 2);
    }

    System.out.println(sum % 10);
  }
}
