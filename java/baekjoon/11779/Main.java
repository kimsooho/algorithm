
/**
 * @author suho kim
 * @no 11779
 * @title 최소비용 구하기 2
 * @url https://www.acmicpc.net/problem/11779
 * @date 2021.10.04
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
  static int MAX = 100000 * 1000;
  static int[] costMemo;
  static int[] route;

  static boolean[] visited;

  static ArrayList<ArrayList<Edge>> graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    graph = new ArrayList<ArrayList<Edge>>();
    costMemo = new int[N + 1];
    route = new int[N + 1];
    visited = new boolean[N + 1];
    for (int i = 0; i <= N; ++i) {
      graph.add(new ArrayList<Edge>());
      costMemo[i] = MAX;
      route[i] = i;
    }

    for (int i = 0; i < M; ++i) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      graph.get(from).add(new Edge(to, cost));
    }

    st = new StringTokenizer(br.readLine());
    int from = Integer.parseInt(st.nextToken());
    int to = Integer.parseInt(st.nextToken());

    run(from, to);
    ArrayList<Integer> r = new ArrayList<Integer>();
    r.add(to);
    int prev = to;

    while (true) {
      if (prev == route[prev]) {
        break;
      }

      prev = route[prev];
      r.add(prev);
    }

    StringBuilder sb = new StringBuilder();
    sb.append(costMemo[to]).append('\n').append(r.size()).append('\n');
    for (int i = r.size() - 1; i >= 0; --i) {
      sb.append(r.get(i) + " ");
    }

    System.out.println(sb);
  }

  private static void run(int from, int to) {
    PriorityQueue<Edge> q = new PriorityQueue<Edge>();
    q.offer(new Edge(from, 0));
    costMemo[from] = 0;

    while (!q.isEmpty()) {
      Edge edge = q.poll();
      int v = edge.v;
      int cost = edge.cost;

      if (visited[v])
        continue;

      visited[v] = true;

      for (Edge _edge : graph.get(edge.v)) {
        int _v = _edge.v;
        int _cost = _edge.cost;

        if (costMemo[_v] > _cost + cost) {
          costMemo[_v] = _cost + cost;
          q.offer(new Edge(_v, costMemo[_v]));
          route[_v] = v;
        }
      }
    }
  }
}
