
/**
 * @author suho kim
 * @no 1251
 * @title 하나로
 * @date 2021.08.25
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair {
  int x;
  int y;

  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class Info implements Comparable<Info> {
  int v;
  long weight;

  public Info(int v, long weight) {
    this.v = v;
    this.weight = weight;
  }

  @Override
  public int compareTo(Info o) {
    return Long.compare(this.weight, o.weight);
  }
}

public class Solution {
  static int N;
  static Pair[] pair;
  static ArrayList<ArrayList<Info>> map;
  static boolean[] visited;
  static PriorityQueue<Info> pq;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; ++t) {
      N = Integer.parseInt(br.readLine());
      pair = new Pair[N];
      map = new ArrayList<ArrayList<Info>>();
      visited = new boolean[N];
      pq = new PriorityQueue<Info>();
      for (int i = 0; i < N; ++i) {
        map.add(new ArrayList<Info>());
      }

      String[] x = br.readLine().split(" ");
      String[] y = br.readLine().split(" ");

      for (int i = 0; i < N; ++i) {
        pair[i] = new Pair(Integer.parseInt(x[i]), Integer.parseInt(y[i]));
      }

      double E = Double.parseDouble(br.readLine());
      for (int i = 0; i < N; ++i) {
        for (int j = i + 1; j < N; ++j) {
          long distance = (long) (Math.pow(pair[i].x - pair[j].x, 2) + Math.pow(pair[i].y - pair[j].y, 2));
          map.get(i).add(new Info(j, distance));
          map.get(j).add(new Info(i, distance));
        }
      }

      pq.offer(new Info(0, 0));
      System.out.println(String.format("#%d %d", t, Math.round(run() * E)));
    }
  }

  private static long run() {
    long ret = 0;
    int count = 0;
    while (!pq.isEmpty()) {
      Info info = pq.poll();

      if (visited[info.v])
        continue;

      visited[info.v] = true;

      ret += info.weight;

      for (Info _info : map.get(info.v)) {
        if (!visited[_info.v]) {
          pq.offer(_info);
        }
      }

      if (++count == N)
        pq.clear();
    }
    return ret;
  }
}
