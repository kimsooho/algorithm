
/**
 * @author suho kim
 * @no 5972
 * @title 택배 배송
 * @url https://www.acmicpc.net/problem/5972
 * @date 2022.01.05
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
  static int M;

  static boolean[] visited;
  static ArrayList<ArrayList<Edge>> graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    visited = new boolean[N + 1];

    graph = new ArrayList<ArrayList<Edge>>();
    for (int i = 0; i < N + 1; ++i) {
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

    System.out.println(run(1));
  }

  private static int run(int v) {
    int retValue = 0;
    PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    pq.offer(new Edge(v, 0));
    while (!pq.isEmpty()) {
      Edge edge = pq.poll();

      if (edge.v == N) {
        retValue = edge.cost;
        break;
      }

      if (visited[edge.v])
        continue;

      visited[edge.v] = true;
      for (Edge _edge : graph.get(edge.v)) {
        pq.offer(new Edge(_edge.v, _edge.cost + edge.cost));
      }
    }

    return retValue;
  }
}
