
/**
 * @author suho kim
 * @no 17471
 * @title 게리맨더링
 * @url https://www.acmicpc.net/problem/17471
 * @date 2021.10.18
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static ArrayList<ArrayList<Integer>> graph;
  static int[] value;

  static int N;
  static boolean[] visitedCom;
  static int[] arrCom;

  static int ret;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    arrCom = new int[N];
    visitedCom = new boolean[N + 1];
    value = new int[N + 1];
    ret = Integer.MAX_VALUE;
    st = new StringTokenizer(br.readLine());

    graph = new ArrayList<ArrayList<Integer>>();
    graph.add(new ArrayList<Integer>());

    for (int i = 1; i <= N; ++i) {
      value[i] = Integer.parseInt(st.nextToken());
      graph.add(new ArrayList<Integer>());
    }

    for (int i = 1; i <= N; ++i) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      for (int j = 0; j < n; ++j) {
        int to = Integer.parseInt(st.nextToken());
        graph.get(i).add(to);
        graph.get(to).add(i);
      }
    }

    comb(0, 1);

    System.out.println(ret == Integer.MAX_VALUE ? -1 : ret);
  }

  private static void comb(int depth, int idx) {
    if (depth > 0) {
      HashSet<Integer> group = new HashSet<Integer>();
      for (int i = 0; i < depth; ++i) {
        group.add(arrCom[i]);
      }
      bfs(group);
    }

    if (depth == N - 1) {
      return;
    }

    for (int i = idx; i <= N; ++i) {
      if (!visitedCom[i]) {
        visitedCom[i] = true;
        arrCom[depth] = i;
        comb(depth + 1, i + 1);
        visitedCom[i] = false;
      }
    }
  }

  private static void bfs(HashSet<Integer> group) {
    boolean[] visited = new boolean[N + 1];
    Queue<Integer> q = new LinkedList<Integer>();
    int start = group.iterator().next();
    int sumA = 0;
    int sumB = 0;
    q.offer(start);
    visited[start] = true;
    while (!q.isEmpty()) {
      int idx = q.poll();
      sumA += value[idx];
      for (int next : graph.get(idx)) {
        if (!visited[next] && group.contains(next)) {
          visited[next] = true;
          q.offer(next);
        }
      }
    }

    Iterator<Integer> iter = group.iterator();
    while (iter.hasNext()) {
      if (!visited[iter.next()])
        return;
    }

    int idxB = 0;
    for (int i = 1; i <= N; ++i) {
      if (!visited[i]) {
        idxB = i;
        break;
      }
    }
    q.offer(idxB);
    visited[idxB] = true;
    while (!q.isEmpty()) {
      int idx = q.poll();
      sumB += value[idx];
      for (int next : graph.get(idx)) {
        if (!visited[next]) {
          visited[next] = true;
          q.offer(next);
        }
      }
    }

    for (int i = 1; i <= N; ++i) {
      if (!visited[i])
        return;
    }
    ret = Math.min(ret, Math.abs(sumA - sumB));

  }
}
