
/**
 * @author suho kim
 * @no 2252
 * @title 줄 세우기
 * @url https://www.acmicpc.net/problem/2252
 * @date 2022.01.23
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] connectedCount;
  static boolean[] visited;
  static ArrayList<ArrayList<Integer>> graph;

  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    connectedCount = new int[N + 1];
    visited = new boolean[N + 1];
    graph = new ArrayList<ArrayList<Integer>>();

    for (int i = 0; i < N + 1; ++i) {
      graph.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < M; ++i) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());

      graph.get(from).add(to);
      ++connectedCount[to];
    }
    run();
  }

  private static void run() {
    Queue<Integer> q = new LinkedList<Integer>();

    for (int i = 1; i < N + 1; ++i) {
      if (connectedCount[i] == 0)
        q.offer(i);
    }

    for (int i = 1; i < N + 1; ++i) {
      int from = q.poll();

      System.out.print(from + " ");

      for (int to : graph.get(from)) {
        if (--connectedCount[to] == 0) {
          q.offer(to);
        }
      }
    }

  }
}
