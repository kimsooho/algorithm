
/**
* @author suho kim
* @no 1767
* @title 프로세서 연결하기
* @date 2021.09.23
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pair {
  int row;
  int col;

  public Pair(int row, int col) {
    this.row = row;
    this.col = col;
  }
}

public class Solution {
  static int[] moveRow = { -1, 1, 0, 0 };
  static int[] moveCol = { 0, 0, -1, 1 };

  static int[][] map;
  static int core;
  static int result;
  static int N;

  static ArrayList<Pair> arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine().trim());
    for (int t = 1; t <= T; ++t) {
      N = Integer.parseInt(br.readLine().trim());
      map = new int[N][N];
      core = 0;
      result = 0;
      arr = new ArrayList<Pair>();
      for (int i = 0; i < N; ++i) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; ++j) {
          map[i][j] = Integer.parseInt(st.nextToken());
          if (map[i][j] == 1) {
            arr.add(new Pair(i, j));
          }
        }
      }
      dfs(0, 0, 0, arr.size());
      System.out.println(String.format("#%d %d", t, result));
    }
  }

  private static void dfs(int idx, int core, int length, int size) {
    if (idx == size) {
      if (core > Solution.core) {
        Solution.core = core;
        result = length;
      } else if (core == Solution.core) {
        result = Math.min(result, length);
      }

      return;
    }

    Pair pair = arr.get(idx);
    for (int i = 0; i < 4; ++i) {
      int l = 0;
      int nextRow = pair.row + moveRow[i];
      int nextCol = pair.col + moveCol[i];
      boolean isConnectable = false;
      while (true) {
        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) {
          isConnectable = true;
          break;
        }

        if (map[nextRow][nextCol] == 1)
          break;

        ++l;
        nextRow += moveRow[i];
        nextCol += moveCol[i];
      }

      if (isConnectable) {
        nextRow = pair.row + moveRow[i];
        nextCol = pair.col + moveCol[i];
        while (!(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N)) {
          map[nextRow][nextCol] = 1;
          nextRow += moveRow[i];
          nextCol += moveCol[i];
        }
        dfs(idx + 1, core + 1, length + l, size);

        nextRow = pair.row + moveRow[i];
        nextCol = pair.col + moveCol[i];
        while (!(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N)) {
          map[nextRow][nextCol] = 0;
          nextRow += moveRow[i];
          nextCol += moveCol[i];
        }
      }
    }

    dfs(idx + 1, core, length, size);
  }
}
