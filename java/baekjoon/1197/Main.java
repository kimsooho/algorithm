
/**
 * @author suho kim
 * @no 1197
 * @title 최소 스패닝 트리
 * @url https://www.acmicpc.net/problem/1197
 * @date 2021.08.31
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Info implements Comparable<Info> {
  int v;
  int cost;

  public Info(int v, int cost) {
    this.v = v;
    this.cost = cost;
  }

  @Override
  public int compareTo(Info o) {
    return this.cost - o.cost;
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    PriorityQueue<Info> pq = new PriorityQueue<Info>();
    ArrayList<ArrayList<Info>> graph = new ArrayList<ArrayList<Info>>();
    boolean[] visited;

    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    visited = new boolean[V + 1];
    for (int i = 0; i < V + 1; ++i) {
      graph.add(new ArrayList<Info>());
    }

    for (int i = 0; i < E; ++i) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      graph.get(from).add(new Info(to, cost));
      graph.get(to).add(new Info(from, cost));
    }

    pq.offer(new Info(1, 0));
    System.out.println(getMinCost(graph, pq, visited));
  }

  private static int getMinCost(ArrayList<ArrayList<Info>> graph, PriorityQueue<Info> pq, boolean[] visited) {
    int cost = 0;
    while (!pq.isEmpty()) {
      Info info = pq.poll();

      if (visited[info.v])
        continue;

      visited[info.v] = true;
      cost += info.cost;
      for (Info _info : graph.get(info.v)) {
        if (!visited[_info.v])
          pq.offer(_info);
      }
    }
    return cost;
  }
}
