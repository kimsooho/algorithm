import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static StringBuilder sb;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());

    int[] original = new int[N];
    int[] output = new int[N];

    boolean[] visited = new boolean[N];

    for (int i = 0; i < N; ++i) {
      original[i] = i+1;
    }
    permutation(original, output, visited, 0, N, N);

    System.out.println(sb);
  }

  private static void permutation(int[] original, int[] output, boolean[] visited, int depth, int n, int r) {
    if (depth == r) {
      for (int num : output) {
        sb.append(String.format("%d ", num));
      }
      sb.append("\n");
    }
    for (int i = 0; i < n; ++i) {
      if (!visited[i]) {
        visited[i] = true;
        output[depth] = original[i];
        permutation(original, output, visited, depth + 1, n, r);
        visited[i] = false;
      }
    }
  }
}
