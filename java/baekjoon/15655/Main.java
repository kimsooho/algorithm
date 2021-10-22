
/**
 * @author suho kim
 * @no 15655
 * @title N과 M (6)
 * @url https://www.acmicpc.net/problem/15655
 * @date 2021.10.22
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
  static ArrayList<Integer> arr;
  static int[] out;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    arr = new ArrayList<Integer>();
    out = new int[M];
    visited = new boolean[N];
    for (int i = 0; i < N; ++i) {
      arr.add(Integer.parseInt(st.nextToken()));
    }

    Collections.sort(arr);

    run(0, 0, M);
  }

  private static void run(int idx, int depth, int M) {
    if (depth == M) {
      for (int i = 0; i < M; ++i) {
        System.out.print(out[i] + " ");
      }
      System.out.println();
      return;
    }

    for (int i = idx; i < arr.size(); ++i) {
      if (!visited[i]) {
        visited[i] = true;
        out[depth] = arr.get(i);
        run(i + 1, depth + 1, M);
        visited[i] = false;
      }
    }
  }
}
