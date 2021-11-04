
/**
 * @author suho kim
 * @no 1956
 * @title 운동
 * @url https://www.acmicpc.net/problem/1956
 * @date 2021.11.04
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int V = Integer.parseInt(st.nextToken()) + 1;
    int E = Integer.parseInt(st.nextToken());

    graph = new int[V][V];

    for (int i = 0; i < V; ++i) {
      for (int j = 0; j < V; ++j) {
        graph[i][j] = Integer.MAX_VALUE / 2;
      }
    }

    for (int i = 0; i < E; ++i) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      graph[from][to] = w;
    }

    for (int via = 0; via < V; ++via) {
      for (int from = 0; from < V; ++from) {
        for (int to = 0; to < V; ++to) {
          graph[from][to] = Math.min(graph[from][to], graph[from][via] + graph[via][to]);
        }
      }
    }
    int retVal = Integer.MAX_VALUE / 2;
    for (int i = 1; i < V; ++i) {
      retVal = Math.min(retVal, graph[i][i]);
    }

    System.out.println(retVal == Integer.MAX_VALUE / 2 ? -1 : retVal);
  }
}
