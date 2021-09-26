
/**
 * @author suho kim
 * @no 11581
 * @title 구호물자
 * @url https://www.acmicpc.net/problem/11581
 * @date 2021.09.26
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    for (int i = 0; i <= N; ++i) {
      graph.add(new ArrayList<Integer>());
    }

    visited = new boolean[N + 1];
    for (int i = 1; i < N; ++i) {
      int M = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; ++j) {
        graph.get(i).add(Integer.parseInt(st.nextToken()));
      }
    }

    System.out.println((isCycle(graph, 1) ? "" : "NO ") + "CYCLE");
  }

  private static boolean isCycle(ArrayList<ArrayList<Integer>> graph, int from) {
    if (visited[from] && graph.get(from).size() > 0) {
      return true;
    }

    visited[from] = true;

    for (int to : graph.get(from)) {
      if (isCycle(graph, to))
        return true;
    }
    visited[from] = false;

    return false;
  }
}
