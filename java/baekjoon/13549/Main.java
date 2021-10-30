
/**
 * @author suho kim
 * @no 13549
 * @title 숨바꼭질 3
 * @url https://www.acmicpc.net/problem/13549
 * @date 2021.10.30
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Info {
  int idx;
  int time;

  public Info(int idx, int time) {
    this.idx = idx;
    this.time = time;
  }
}

public class Main {
  static final int MAX = 100001;
  static int N;
  static int K;
  static Queue<Info> q;
  static boolean[] visited;

  static int minTime;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    visited = new boolean[MAX];
    q = new LinkedList<Info>();

    q.offer(new Info(N, 0));
    minTime = Integer.MAX_VALUE;
    bfs();

    System.out.println(minTime);
  }

  private static void bfs() {
    while (!q.isEmpty()) {
      Info info = q.poll();
      int pos = info.idx;
      int time = info.time;

      visited[pos] = true;
      if (pos == K) {
        minTime = time;
        break;
      }

      if (pos - 1 >= 0 && !visited[pos - 1]) {
        q.offer(new Info(pos - 1, time + 1));
      }

      if (pos * 2 < MAX && !visited[pos * 2]) {
        q.offer(new Info(pos * 2, time));
      }

      if (pos + 1 < MAX && !visited[pos + 1]) {
        q.offer(new Info(pos + 1, time + 1));
      }
    }
  }
}
