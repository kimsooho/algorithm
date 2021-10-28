
/**
 * @author suho kim
 * @no 15666
 * @title N과 M (12)
 * @url https://www.acmicpc.net/problem/15666
 * @date 2021.10.29
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
  static HashSet<String> set;
  static ArrayList<Integer> arr;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    set = new HashSet<String>();
    arr = new ArrayList<Integer>();
    sb = new StringBuilder();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; ++i) {
      arr.add(Integer.parseInt(st.nextToken()));
    }

    Collections.sort(arr);

    run(0, 0, N, M, "");
    System.out.print(sb);
  }

  private static void run(int idx, int depth, int N, int M, String out) {
    if (depth == M) {
      if (!set.contains(out)) {
        set.add(out);
        sb.append(out + "\n");
      }
      return;
    }

    for (int i = idx; i < N; ++i) {
      run(i, depth + 1, N, M, out + arr.get(i) + " ");
    }
  }
}
