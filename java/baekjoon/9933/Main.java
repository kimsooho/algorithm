
/**
 * @author suho kim
 * @no 9933
 * @title 민균이의 비밀번호
 * @url https://www.acmicpc.net/problem/9933
 * @date 2021.11.20
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    HashSet<String> hashSet = new HashSet<String>();
    for (int i = 0; i < N; ++i) {
      String line = br.readLine();
      StringBuilder sb = new StringBuilder();
      sb.append(line);

      hashSet.add(sb.reverse().toString());

      if (hashSet.contains(sb.reverse().toString())) {
        System.out.println(sb.length());
        System.out.println(sb.charAt(sb.length() / 2));
      }
    }
  }
}
