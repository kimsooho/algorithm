
/**
 * @author suho kim
 * @no 1504
 * @title 특정한 최단 경로
 * @url https://www.acmicpc.net/problem/1504
 * @date 2021.10.02
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
  int v;
  int distance;

  public Edge(int v, int distance) {
    this.v = v;
    this.distance = distance;
  }

  @Override
  public int compareTo(Edge o) {
    return this.distance - o.distance;
  }
}

public class Main {
  static ArrayList<ArrayList<Edge>> graph;
  static int[] distanceMemo;

  static int N;

  static int MAX = 200000 * 1000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    graph = new ArrayList<ArrayList<Edge>>();
    distanceMemo = new int[N + 1];
    for (int i = 0; i <= N; ++i) {
      graph.add(new ArrayList<Edge>());
    }

    for (int i = 0; i < E; ++i) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int distance = Integer.parseInt(st.nextToken());

      graph.get(from).add(new Edge(to, distance));
      graph.get(to).add(new Edge(from, distance));
    }
    st = new StringTokenizer(br.readLine());

    int route1 = Integer.parseInt(st.nextToken());
    int route2 = Integer.parseInt(st.nextToken());

    int distance1 = run(1, route1);
    distance1 += run(route1, route2);
    distance1 += run(route2, N);

    int distance2 = run(1, route2);
    distance2 += run(route2, route1);
    distance2 += run(route1, N);
    if (distance1 >= MAX || distance2 >= MAX) {
      System.out.println(-1);
    } else {
      System.out.println(Math.min(distance1, distance2));
    }
  }

  private static int run(int start, int end) {
    for (int i = 0; i <= N; ++i) {
      distanceMemo[i] = MAX;
    }

    PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    pq.offer(new Edge(start, 0));
    distanceMemo[start] = 0;
    while (!pq.isEmpty()) {
      Edge edge = pq.poll();

      for (Edge _edge : graph.get(edge.v)) {
        if (distanceMemo[_edge.v] > distanceMemo[edge.v] + _edge.distance) {
          distanceMemo[_edge.v] = distanceMemo[edge.v] + _edge.distance;
          pq.offer(new Edge(_edge.v, distanceMemo[_edge.v]));
        }
      }
    }

    return distanceMemo[end];
  }
}
