
/**
 * @author suho kim
 * @no 4386
 * @title 별자리 만들기
 * @url https://www.acmicpc.net/problem/4386
 * @date 2022.01.18
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point {
  double x;
  double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }
}

class Edge implements Comparable<Edge> {
  String v;
  double distance;

  public Edge(String v, double distance) {
    this.v = v;
    this.distance = distance;
  }

  @Override
  public int compareTo(Edge o) {
    return Double.compare(this.distance, o.distance);
  }
}

public class Main {
  static HashMap<String, Boolean> visited;
  static HashMap<String, ArrayList<Edge>> graph;
  static PriorityQueue<Edge> pq;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    visited = new HashMap<String, Boolean>();
    pq = new PriorityQueue<Edge>();

    List<Point> points = new ArrayList<Point>();
    graph = new HashMap<String, ArrayList<Edge>>();
    int N = Integer.parseInt(st.nextToken());
    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      double x = Double.parseDouble(st.nextToken());
      double y = Double.parseDouble(st.nextToken());
      String from = String.format("%f%f", x, y);
      Point fromPoint = new Point(x, y);
      points.add(fromPoint);
      visited.put(from, false);

      graph.put(from, new ArrayList<Edge>());

      for (int j = 0; j < i; ++j) {
        Point toPoint = points.get(j);
        String to = String.format("%f%f", toPoint.x, toPoint.y);
        double distance = getDistance(fromPoint, toPoint);

        graph.get(from).add(new Edge(to, distance));
        graph.get(to).add(new Edge(from, distance));
      }
    }
    pq.offer(new Edge(String.format("%f%f", points.get(0).x, points.get(0).y), 0));
    System.out.println(String.format("%.2f", run()));
  }

  private static double run() {
    double result = 0;

    while (!pq.isEmpty()) {
      Edge edge = pq.poll();
      if (visited.get(edge.v))
        continue;

      visited.replace(edge.v, true);
      result += edge.distance;

      for (Edge _edge : graph.get(edge.v)) {
        if (!visited.get(_edge.v))
          pq.offer(_edge);
      }
    }

    return result;
  }

  private static double getDistance(Point p1, Point p2) {
    return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
  }
}
