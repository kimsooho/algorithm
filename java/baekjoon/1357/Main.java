
/**
 * @author suho kim
 * @no 1357
 * @title 뒤집힌 덧셈
 * @url https://www.acmicpc.net/problem/1357
 * @date 2021.10.03
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int X = Integer.parseInt(st.nextToken());
    int Y = Integer.parseInt(st.nextToken());

    StringBuilder sb = new StringBuilder();
    int revX = Integer.valueOf(sb.append(X).reverse().toString());
    sb = new StringBuilder();
    int revY = Integer.valueOf(sb.append(Y).reverse().toString());

    int ret = revX + revY;
    sb = new StringBuilder();
    System.out.println(Integer.valueOf(sb.append(ret).reverse().toString()));
  }
}
