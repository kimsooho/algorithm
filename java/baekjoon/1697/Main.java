import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static final int MAX = 100001;
  static int N;
  static int K;
  static int[] visited;
  static Queue<Integer> q;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    visited = new int[MAX];
    q = new LinkedList<Integer>();

    Arrays.fill(visited, -1);

    q.offer(N);
    visited[N] = 0;
    bfs();

    System.out.println(visited[K]);
  }

  private static void bfs() {
    while (!q.isEmpty()) {
      int pos = q.poll();

      if (pos == K)
        return;

      if (pos - 1 >= 0 && visited[pos - 1] == -1) {
        visited[pos - 1] = visited[pos] + 1;
        q.offer(pos - 1);
      }

      if (pos + 1 < MAX && visited[pos + 1] == -1) {
        visited[pos + 1] = visited[pos] + 1;
        q.offer(pos + 1);
      }

      if (pos * 2 < MAX && visited[pos * 2] == -1) {
        visited[pos * 2] = visited[pos] + 1;
        q.offer(pos * 2);
      }
    }
  }
}
