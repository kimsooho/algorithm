
/**
* @author suho kim
* @no 3124
* @title 최소 스패닝 트리
* @date 2021.09.15
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Info implements Comparable<Info> {
  int v;
  int weight;

  public Info(int v, int weight) {
    this.v = v;
    this.weight = weight;
  }

  @Override
  public int compareTo(Info o) {
    return this.weight - o.weight;
  }
}

public class Solution {
  static ArrayList<ArrayList<Info>> link;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());

    for (int t = 1; t <= T; ++t) {
      st = new StringTokenizer(br.readLine());

      int V = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());

      visited = new boolean[V + 1];
      link = new ArrayList<ArrayList<Info>>();
      for (int i = 0; i <= V; ++i) {
        link.add(new ArrayList<Info>());
      }

      for (int i = 0; i < E; ++i) {
        st = new StringTokenizer(br.readLine());

        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        link.get(from).add(new Info(to, w));
        link.get(to).add(new Info(from, w));
      }

      long weight = run();
      System.out.println(String.format("#%d %d", t, weight));
    }
  }

  private static long run() {
    long weight = 0;
    PriorityQueue<Info> pq = new PriorityQueue<Info>();
    pq.offer(new Info(1, 0));

    while (!pq.isEmpty()) {
      Info info = pq.poll();

      if (visited[info.v])
        continue;

      visited[info.v] = true;
      weight += info.weight;
      for (Info _info : link.get(info.v)) {
        if (!visited[_info.v]) {
          pq.offer(_info);
        }
      }

    }

    return weight;
  }
}
