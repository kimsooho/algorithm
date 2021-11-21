
/**
 * @author suho kim
 * @no 1240
 * @title 노드사이의 거리
 * @url https://www.acmicpc.net/problem/1240
 * @date 2021.11.21
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
    int M = Integer.parseInt(st.nextToken());

    int[][] map = new int[N + 1][N + 1];

    for (int i = 1; i <= N; ++i) {
      for (int j = 1; j <= N; ++j) {
        map[i][j] = Integer.MAX_VALUE / 2;
      }
    }

    for (int i = 0; i < N - 1; ++i) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      map[from][to] = cost;
      map[to][from] = cost;
    }

    for (int via = 1; via <= N; ++via) {
      for (int from = 1; from <= N; ++from) {
        for (int to = 1; to <= N; ++to) {
          map[from][to] = Math.min(map[from][to], map[from][via] + map[via][to]);
        }
      }
    }

    for (int i = 0; i < M; ++i) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());

      System.out.println(map[from][to]);
    }
  }
}
