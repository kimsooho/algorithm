
/**
 * @author suho kim
 * @no 9093
 * @title 단어 뒤집기
 * @url https://www.acmicpc.net/problem/9093
 * @date 2021.09.19
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      StringBuffer sb = new StringBuffer();
      String[] str = br.readLine().split(" ");
      for (int i = 0; i < str.length; ++i) {
        StringBuilder s = new StringBuilder();
        s.append(str[i]);
        s.reverse();

        sb.append(s + " ");
      }
      System.out.println(sb);
    }
  }
}
