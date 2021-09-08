
/**
 * @author suho kim
 * @no 18223
 * @title 민준이와 마산 그리고 건우
 * @url https://www.acmicpc.net/problem/18223
 * @date 2021.09.08
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Info implements Comparable<Info> {
  int v;
  int distance;

  public Info(int v, int distance) {
    this.v = v;
    this.distance = distance;
  }

  @Override
  public int compareTo(Info o) {
    return this.distance - o.distance;
  }
}

class DistInfo {
  int distance;
  ArrayList<Integer> route;

  public DistInfo(int distance) {
    this.distance = distance;
    route = new ArrayList<Integer>();
  }
}

public class Main {
  static DistInfo[] distance;
  static ArrayList<ArrayList<Info>> map;
  static PriorityQueue<Info> pq;

  static int minValue;
  static ArrayList<ArrayList<Integer>> route;
  static int V;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());

    minValue = Integer.MAX_VALUE;
    route = new ArrayList<ArrayList<Integer>>();

    distance = new DistInfo[V + 1];

    for (int i = 0; i < V + 1; ++i) {
      distance[i] = new DistInfo(Integer.MAX_VALUE);
    }
    pq = new PriorityQueue<Info>();
    map = new ArrayList<ArrayList<Info>>();

    for (int i = 0; i < V + 1; ++i) {
      map.add(new ArrayList<Info>());
    }

    for (int i = 0; i < E; ++i) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int nDistance = Integer.parseInt(st.nextToken());

      map.get(from).add(new Info(to, nDistance));
      map.get(to).add(new Info(from, nDistance));
    }

    distance[1].distance = 0;
    distance[1].route.add(1);

    pq.offer(new Info(1, 0));

    run();

    for (ArrayList<Integer> arr : route) {
      for (int num : arr) {
        if (num == P) {
          System.out.println("SAVE HIM");
          return;
        }
      }
    }

    System.out.println("GOOD BYE");
  }

  private static void run() {
    while (!pq.isEmpty()) {
      int v = pq.peek().v;
      int dist = pq.peek().distance;
      pq.poll();

      for (Info _info : map.get(v)) {
        int v2 = _info.v;
        int dist2 = _info.distance;

        if (distance[v2].distance >= dist + dist2) {
          distance[v2].distance = dist + dist2;
          distance[v2].route = new ArrayList<Integer>(distance[v].route);
          distance[v2].route.add(v2);
          if (v2 == V) {
            if (minValue > distance[v2].distance) {
              minValue = distance[v2].distance;

              route.clear();
            }

            route.add(distance[v2].route);
          }
          pq.offer(new Info(v2, distance[v2].distance));
        }
      }
    }
  }
}