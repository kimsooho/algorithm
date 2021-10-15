
/**
 * @author suho kim
 * @no 16430
 * @title 제리와 톰
 * @url https://www.acmicpc.net/problem/16430
 * @date 2021.10.15
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    System.out.println(B - A + " " + B);
  }
}
