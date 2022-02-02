
/**
 * @author suho kim
 * @no 1238
 * @title 파티
 * @url https://www.acmicpc.net/problem/1238
 * @date 2022.02.03
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
  static int X;

  static ArrayList<ArrayList<Edge>> graph;

  static int[] memo;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());

    memo = new int[N + 1];
    graph = new ArrayList<ArrayList<Edge>>();

    for (int i = 0; i <= N; ++i) {
      graph.add(new ArrayList<Edge>());
      memo[i] = Integer.MAX_VALUE;
    }

    for (int i = 0; i < M; ++i) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      graph.get(from).add(new Edge(to, cost));
    }

    run();

  }

  private static void run() {

    for (int i = 1; i <= N; ++i) {
      if (i == X)
        continue;

      memo[i] = getValue(i, X);
    }

    for (int i = 1; i <= N; ++i) {
      if (i == X)
        continue;

      memo[i] += getValue(X, i);
    }

    int retValue = 0;
    for (int i = 1; i <= N; ++i) {
      if (i == X)
        continue;

      retValue = Integer.max(memo[i], retValue);
    }

    System.out.println(retValue);
  }

  private static int getValue(int from, int to) {
    PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    int retValue = 0;

    boolean[] visited = new boolean[N + 1];

    pq.offer(new Edge(from, 0));
    while (!pq.isEmpty()) {
      Edge edge = pq.poll();

      if (edge.v == to) {
        retValue = edge.cost;
        break;
      }
      if (visited[edge.v])
        continue;

      visited[edge.v] = true;

      for (Edge _edge : graph.get(edge.v)) {
        pq.offer(new Edge(_edge.v, edge.cost + _edge.cost));
      }

    }

    return retValue;
  }
}
