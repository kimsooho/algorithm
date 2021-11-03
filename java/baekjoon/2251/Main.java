
/**
 * @author suho kim
 * @no 2251
 * @title 물통
 * @url https://www.acmicpc.net/problem/2251
 * @date 2021.11.03
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Bucket {
  int[] amounts;

  public Bucket(int A, int B, int C) {
    amounts = new int[] { A, B, C };
  }
}

public class Main {
  static int[] limit;
  static boolean[][] visited;
  static TreeSet<Integer> ts;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    limit = new int[] { A, B, C };
    visited = new boolean[201][201];
    ts = new TreeSet<Integer>();

    bfs(C);

    Iterator<Integer> iter = ts.iterator();
    while (iter.hasNext()) {
      System.out.print(iter.next() + " ");
    }
  }

  private static void bfs(int C) {
    Queue<Bucket> q = new LinkedList<Bucket>();
    q.offer(new Bucket(0, 0, C));
    visited[0][0] = true;
    while (!q.isEmpty()) {
      Bucket bucket = q.poll();
      if (bucket.amounts[0] == 0)
        ts.add(bucket.amounts[2]);

      // A to B
      // A to C
      // B to C
      // B to A
      // C to A
      // C to B
      for (int from = 0; from < 3; ++from) {
        for (int to = 0; to < 3; ++to) {
          if (from == to)
            continue;

          int[] amounts = new int[] { bucket.amounts[0], bucket.amounts[1], bucket.amounts[2] };
          if (amounts[from] + amounts[to] <= limit[to]) { // 다 들어간다
            amounts[to] += amounts[from];
            amounts[from] = 0;
          } else { // 다 안들어 간다
            amounts[from] -= (limit[to] - amounts[to]);
            amounts[to] = limit[to];
          }

          if (!visited[amounts[0]][amounts[1]]) {
            visited[amounts[0]][amounts[1]] = true;
            q.offer(new Bucket(amounts[0], amounts[1], amounts[2]));
          }
        }
      }

    }
  }
}
