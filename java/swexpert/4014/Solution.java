
/**
 * @author suho kim
 * @no 4014
 * @title 활주로 건설
 * @date 2021.10.06
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int N;
  static int X;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; ++t) {
      int result = 0;
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      X = Integer.parseInt(st.nextToken());

      int[][] rowMap = new int[N][N];
      int[][] colMap = new int[N][N];

      for (int i = 0; i < N; ++i) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; ++j) {
          colMap[i][j] = rowMap[j][i] = Integer.parseInt(st.nextToken());
        }
      }

      for (int i = 0; i < N; ++i) {
        if (buildable(rowMap[i]))
          ++result;

        if (buildable(colMap[i]))
          ++result;
      }
      System.out.println(String.format("#%d %d", t, result));
    }
  }

  private static boolean buildable(int[] line) {
    int prev;
    int equalCount = 1;
    for (int i = 1; i < N; ++i) {
      prev = line[i - 1];
      if (prev == line[i]) {
        ++equalCount;
      } else if (prev - line[i] == 1) { // 내리막
        if (i + X > N) {
          return false;
        }

        for (int nowIdx = i; i < nowIdx + X - 1; ++i) {
          if (line[i] != line[i + 1]) {
            return false;
          }
        }

        equalCount = 0;
      } else if (line[i] - prev == 1) { // 오르막
        if (equalCount < X) {
          return false;
        }

        equalCount = 1;
      } else {
        return false;
      }

    }
    return true;
  }
}
