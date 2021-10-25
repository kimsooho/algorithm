
/**
 * @author suho kim
 * @no 15664
 * @title N과 M (10)
 * @url https://www.acmicpc.net/problem/15664
 * @date 2021.10.25
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

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    set = new HashSet<String>();
    arr = new ArrayList<Integer>();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; ++i) {
      arr.add(Integer.parseInt(st.nextToken()));
    }

    Collections.sort(arr);

    run(0, 0, N, M, "");
  }

  private static void run(int idx, int depth, int N, int M, String out) {
    if (depth == M) {
      if (!set.contains(out)) {
        set.add(out);
        System.out.println(out);
      }
      return;
    }

    for (int i = idx; i < N; ++i) {
      run(i + 1, depth + 1, N, M, out + arr.get(i) + " ");
    }
  }
}
