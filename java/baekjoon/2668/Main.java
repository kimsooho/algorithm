
/**
 * @author suho kim
 * @no 2668
 * @title 숫자고르기
 * @url https://www.acmicpc.net/problem/2668
 * @date 2021.11.09
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine().trim());

    int[][] graph = new int[N + 1][N + 1];

    for (int i = 1; i <= N; ++i) {
      for (int j = 1; j <= N; ++j) {
        graph[i][j] = Integer.MAX_VALUE / 2;
      }
    }
    for (int i = 1; i <= N; ++i) {
      graph[i][Integer.parseInt(br.readLine().trim())] = 1;
    }

    for (int via = 1; via <= N; ++via) {
      for (int from = 1; from <= N; ++from) {
        for (int to = 1; to <= N; ++to) {
          graph[from][to] = Math.min(graph[from][to], graph[from][via] + graph[via][to]);
        }
      }
    }

    List<Integer> list = new ArrayList<Integer>();
    for (int i = 1; i <= N; ++i) {
      if (graph[i][i] != Integer.MAX_VALUE / 2) {
        list.add(i);
      }
    }

    System.out.println(list.size());
    StringBuilder sb = new StringBuilder();
    for (int num : list) {
      sb.append(num).append("\n");
    }

    System.out.print(sb);
  }
}
