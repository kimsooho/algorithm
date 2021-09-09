import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] parent;
  static ArrayList<ArrayList<Integer>> link;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    parent = new int[N];
    visited = new boolean[N];
    link = new ArrayList<ArrayList<Integer>>();

    for (int i = 0; i < N; ++i) {
      link.add(new ArrayList<Integer>());
    }
    st = new StringTokenizer(br.readLine());

    int root = 0;

    int[] temp = new int[N];
    for (int i = 0; i < N; ++i) {
      temp[i] = Integer.parseInt(st.nextToken());
      if (temp[i] == -1)
        root = i;
    }

    int deleteNode = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; ++i) {
      int parent = temp[i];
      if (i == deleteNode || parent == deleteNode)
        continue;
      if (parent != -1) {
        link.get(parent).add(i);
      }
    }

    System.out.println(bfs(root, deleteNode));
  }

  private static int bfs(int root, int deleteNode) {
    Queue<Integer> q = new LinkedList<Integer>();
    q.offer(root);
    int count = 0;
    while (!q.isEmpty()) {
      int parent = q.poll();

      if (link.get(parent).isEmpty() && deleteNode != parent)
        ++count;
      for (int child : link.get(parent)) {
        if (!visited[child]) {
          q.offer(child);
          visited[child] = true;
        }
      }
    }

    return count;
  }
}