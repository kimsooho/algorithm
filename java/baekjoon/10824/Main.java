
/**
 * @author suho kim
 * @no 10824
 * @title 네 수
 * @url https://www.acmicpc.net/problem/10824
 * @date 2021.11.22
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    String AB = st.nextToken() + st.nextToken();
    String CD = st.nextToken() + st.nextToken();

    System.out.println(Long.parseLong(AB) + Long.parseLong(CD));
  }
}
