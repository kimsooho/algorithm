
/**
 * @author suho kim
 * @no 1707
 * @title 이분 그래프
 * @url https://www.acmicpc.net/problem/1707
 * @date 2021.09.07
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int t = Integer.parseInt(br.readLine());
    while (t-- != 0) {
      st = new StringTokenizer(br.readLine());
      int V = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());
      visited = new int[V + 1];
      Arrays.fill(visited, -1);

      ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

      for (int i = 0; i < V + 1; ++i) {
        arr.add(new ArrayList<Integer>());
      }

      for (int i = 0; i < E; ++i) {
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        arr.get(from).add(to);
        arr.get(to).add(from);
      }

      boolean isValid = true;
      for (int i = 1; i < V + 1; ++i) {
        if (visited[i] == -1) {
          if (!isValid(arr, i)) {
            isValid = false;
            break;
          }
        }
      }
      // System.out.println(Arrays.toString(visited));
      System.out.println(isValid ? "YES" : "NO");
    }
  }

  private static boolean isValid(ArrayList<ArrayList<Integer>> arr, int start) {
    boolean isValid = true;
    Queue<Integer> q = new LinkedList<Integer>();
    q.offer(start);
    visited[start] = 1;

    while (!q.isEmpty() && isValid) {
      int idx = q.poll();
      for (int i = 0; i < arr.get(idx).size(); ++i) {
        if (visited[arr.get(idx).get(i)] == -1) {
          q.offer(arr.get(idx).get(i));
          visited[arr.get(idx).get(i)] = ~visited[idx] & 1;
        } else if ((visited[arr.get(idx).get(i)] ^ visited[idx]) == 0) {
          q.clear();
          isValid = false;
          break;
        }
      }
    }

    return isValid;
  }
}
