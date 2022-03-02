
/**
 * @author suho kim
 * @no 1719
 * @title 택배
 * @url https://www.acmicpc.net/problem/1719
 * @date 2022.03.02
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

    int[][] result = new int[N + 1][N + 1];
    int[][] value = new int[N + 1][N + 1];

    for (int i = 1; i < N + 1; ++i) {
      for (int j = 1; j < N + 1; ++j) {
        value[i][j] = Integer.MAX_VALUE / 2;
      }
    }

    for (int i = 0; i < M; ++i) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      value[from][to] = cost;
      value[to][from] = cost;
      result[from][to] = to;
      result[to][from] = from;
    }

    for (int via = 1; via < N + 1; ++via) {
      for (int from = 1; from < N + 1; ++from) {
        for (int to = 1; to < N + 1; ++to) {
          if (value[from][to] > value[from][via] + value[via][to]) {
            result[from][to] = result[from][via];
            value[from][to] = value[from][via] + value[via][to];
          }
        }
      }
    }

    for (int i = 1; i < N + 1; ++i) {
      for (int j = 1; j < N + 1; ++j) {
        if (i == j) {
          System.out.print("- ");
        } else {
          System.out.print(result[i][j] + " ");
        }
      }
      System.out.println();
    }
  }
}
