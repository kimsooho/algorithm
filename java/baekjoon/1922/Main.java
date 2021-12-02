
/**
 * @author suho kim
 * @no 1922
 * @title 네트워크 연결
 * @url https://www.acmicpc.net/problem/1922
 * @date 2021.12.02
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
  int v;
  int cost;

  public Edge(int v, int cost) {
    this.v = v;
    this.cost = cost;
  }

  @Override
  public int compareTo(Edge o) {
    return this.cost - o.cost;
  }
}

public class Main {
  static int N;
  static int M;
  static List<ArrayList<Edge>> graph;

  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    graph = new ArrayList<ArrayList<Edge>>();
    N = Integer.parseInt(br.readLine().trim());
    M = Integer.parseInt(br.readLine().trim());
    visited = new boolean[N + 1];
    for (int i = 0; i <= N; ++i) {
      graph.add(new ArrayList<Edge>());
    }

    for (int i = 0; i < M; ++i) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      graph.get(from).add(new Edge(to, cost));
      graph.get(to).add(new Edge(from, cost));
    }

    System.out.println(run());
  }

  private static int run() {
    int retVal = 0;
    PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    pq.offer(new Edge(1, 0));
    while (!pq.isEmpty()) {
      Edge edge = pq.poll();
      if (visited[edge.v])
        continue;

      visited[edge.v] = true;
      retVal += edge.cost;
      for (Edge _edge : graph.get(edge.v)) {
        pq.offer(_edge);
      }
    }
    return retVal;
  }
}
