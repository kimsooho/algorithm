
/**
 * @author suho kim
 * @no 1446
 * @title 지름길
 * @url https://www.acmicpc.net/problem/1446
 * @date 2021.11.10
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Info {
  int pos;
  int cost;

  public Info(int pos, int cost) {
    this.pos = pos;
    this.cost = cost;
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int D = Integer.parseInt(st.nextToken());

    HashMap<Integer, HashMap<Integer, Integer>> hash = new HashMap<Integer, HashMap<Integer, Integer>>();
    int[] costs = new int[D + 1];
    Arrays.fill(costs, Integer.MAX_VALUE);
    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      if (end - start <= cost || end > D)
        continue;

      if (hash.containsKey(start)) {
        if (!hash.get(start).containsKey(end)) {
          hash.get(start).put(end, cost);
        } else if (cost < hash.get(start).get(end)) {
          hash.get(start).replace(end, cost);
        }
      } else {
        hash.put(start, new HashMap<Integer, Integer>());
        hash.get(start).put(end, cost);
      }
    }
    int result = Integer.MAX_VALUE;
    Queue<Info> q = new LinkedList<Info>();
    q.offer(new Info(0, 0));
    while (!q.isEmpty()) {
      Info info = q.poll();
      int pos = info.pos;
      int cost = info.cost;

      if (pos == D) {
        result = Math.min(result, cost);
        continue;
      }
      if (hash.containsKey(pos)) {
        for (int key : hash.get(pos).keySet()) {
          if (costs[key] > cost + hash.get(pos).get(key)) {
            costs[key] = cost + hash.get(pos).get(key);
            q.offer(new Info(key, cost + hash.get(pos).get(key)));
          }
        }
      }

      if (costs[pos + 1] > cost + 1) {
        costs[pos + 1] = cost + 1;
        q.offer(new Info(pos + 1, cost + 1));
      }
    }

    System.out.println(result);
  }
}
