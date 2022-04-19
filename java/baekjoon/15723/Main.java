
/**
 * @author suho kim
 * @no 15723
 * @title n단 논법
 * @url https://www.acmicpc.net/problem/15723
 * @date 2022.04.20
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int alpha = 26;
    int[][] graph = new int[alpha][alpha];
    for (int i = 0; i < alpha; ++i) {
      for (int j = 0; j < alpha; ++j) {
        graph[i][j] = Integer.MAX_VALUE / 2;
      }
    }
    int m = Integer.parseInt(br.readLine().trim());
    for (int i = 0; i < m; ++i) {
      String compare = br.readLine().trim();
      int A = compare.charAt(0) - 'a';
      int B = compare.charAt(compare.length() - 1) - 'a';
      graph[A][B] = 0;
    }

    for (int via = 0; via < alpha; ++via) {
      for (int from = 0; from < alpha; ++from) {
        for (int to = 0; to < alpha; ++to) {
          graph[from][to] = Math.min(graph[from][to], graph[from][via] + graph[via][to]);
        }
      }
    }

    int n = Integer.parseInt(br.readLine().trim());
    for (int i = 0; i < n; ++i) {
      String compare = br.readLine().trim();
      int A = compare.charAt(0) - 'a';
      int B = compare.charAt(compare.length() - 1) - 'a';
      System.out.println(graph[A][B] == 0 ? "T" : "F");
    }
  }
}
