
/**
 * @author suho kim
 * @no 11403
 * @title 경로 찾기
 * @url https://www.acmicpc.net/problem/11403
 * @date 2021.11.06
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());

    int[][] map = new int[N][N];

    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 0) {
          map[i][j] = Integer.MAX_VALUE / 2;
        }
      }
    }

    for (int via = 0; via < N; ++via) {
      for (int from = 0; from < N; ++from) {
        for (int to = 0; to < N; ++to) {
          map[from][to] = Math.min(map[from][to], map[from][via] + map[via][to]);
        }
      }
    }

    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        sb.append((map[i][j] == Integer.MAX_VALUE / 2 ? 0 : 1) + " ");
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }
}
