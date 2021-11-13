
/**
 * @author suho kim
 * @no 2525
 * @title 오븐 시계
 * @url https://www.acmicpc.net/problem/2525
 * @date 2021.11.13
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
    int C = Integer.parseInt(br.readLine().trim());
    B += C;

    A += B / 60;
    A %= 24;
    B %= 60;

    System.out.println(A + " " + B);
  }
}
