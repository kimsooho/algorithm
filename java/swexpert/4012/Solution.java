import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  static int N;
  static int[][] map;

  static boolean[] isSelected;

  static int minValue;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());
    for (int t = 1; t <= T; ++t) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());

      map = new int[N][N];
      isSelected = new boolean[N];
      minValue = Integer.MAX_VALUE;
      for (int i = 0; i < N; ++i) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; ++j) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      cmb(0, 0);
      System.out.println(String.format("#%d %d", t, minValue));
    }
  }

  private static void cmb(int c, int start) {
    if (c == N / 2) {
      int a = 0;
      int b = 0;

      for (int i = 0; i < N; ++i) {
        for (int j = i + 1; j < N; ++j) {
          if (isSelected[i] & isSelected[j])
            a += map[i][j] + map[j][i];
          else if (!(isSelected[i] | isSelected[j]))
            b += map[i][j] + map[j][i];
        }
      }

      minValue = Math.min(minValue, Math.abs(a - b));
      return;
    }
    for (int i = start; i < N; ++i) {
      isSelected[i] = true;
      cmb(c + 1, i + 1);
      isSelected[i] = false;
    }
  }
}
