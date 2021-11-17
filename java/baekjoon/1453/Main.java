
/**
 * @author suho kim
 * @no 1453
 * @title 피시방 알바
 * @url https://www.acmicpc.net/problem/1453
 * @date 2021.11.17
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    boolean[] visited = new boolean[101];
    int N = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int count = 0;
    for (int i = 0; i < N; ++i) {
      int n = Integer.parseInt(st.nextToken());
      if (visited[n])
        ++count;

      visited[n] = true;
    }

    System.out.println(count);
  }
}
