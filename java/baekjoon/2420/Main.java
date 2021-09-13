
/**
 * @author suho kim
 * @no 2420
 * @title 사파리월드
 * @url https://www.acmicpc.net/problem/2420
 * @date 2021.09.13
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long N = Integer.parseInt(st.nextToken());
    long M = Integer.parseInt(st.nextToken());

    System.out.println(Math.abs(N - M));
  }
}
