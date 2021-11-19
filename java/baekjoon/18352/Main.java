
/**
 * @author suho kim
 * @no 18352
 * @title 특정 거리의 도시 찾기
 * @url https://www.acmicpc.net/problem/18352
 * @date 2021.11.19
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
  static int K;
  static int X;

  static List<ArrayList<Edge>> graph;

  static int[] costs;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());

    graph = new ArrayList<ArrayList<Edge>>();
    costs = new int[N + 1];
    visited = new boolean[N + 1];

    for (int i = 0; i <= N; ++i) {
      graph.add(new ArrayList<Edge>());
      costs[i] = Integer.MAX_VALUE / 2;
    }

    for (int i = 0; i < M; ++i) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());

      graph.get(from).add(new Edge(to, 1));
    }

    run();

    boolean isValid = false;
    for (int i = 1; i <= N; ++i) {
      if (costs[i] == K) {
        System.out.println(i);
        isValid = true;
      }
    }
    if (!isValid)
      System.out.println(-1);
  }

  private static void run() {
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    pq.offer(new Edge(X, 0));
    costs[X] = 0;

    while (!pq.isEmpty()) {
      Edge edge = pq.poll();

      if (visited[edge.v])
        continue;
      visited[edge.v] = true;

      for (Edge e : graph.get(edge.v)) {
        if (costs[e.v] > edge.cost + e.cost) {
          costs[e.v] = edge.cost + e.cost;
          pq.offer(new Edge(e.v, costs[e.v]));
        }
      }
    }
  }
}
