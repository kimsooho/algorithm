
/**
 * @author suho kim
 * @no 3967
 * @title 매직 스타
 * @url https://www.acmicpc.net/problem/3967
 * @date 2022.03.02
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
  static char[][] map;
  static char[][] result;
  static boolean[] visited;

  static boolean isFinished;
  static int[][][] idxs;

  static List<Integer[]> arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    map = new char[5][9];
    result = new char[5][9];
    visited = new boolean[12];
    isFinished = false;
    arr = new ArrayList<Integer[]>();
    idxs = new int[][][] {
        {
            { 0, 4 }, { 1, 3 }, { 2, 2 }, { 3, 1 }
        },
        {
            { 1, 1 }, { 1, 3 }, { 1, 5 }, { 1, 7 }
        },
        {
            { 3, 1 }, { 3, 3 }, { 3, 5 }, { 3, 7 }
        },
        {
            { 0, 4 }, { 1, 5 }, { 2, 6 }, { 3, 7 }
        },
        {
            { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 }
        },
        {
            { 1, 7 }, { 2, 6 }, { 3, 5 }, { 4, 4 }
        }
    };
    int selectedCount = 0;
    for (int i = 0; i < 5; ++i) {
      String[] split = br.readLine().split("");
      for (int j = 0; j < 9; ++j) {
        map[i][j] = split[j].charAt(0);
        result[i][j] = map[i][j];
        if ('A' <= map[i][j] && map[i][j] <= 'L') {
          visited[map[i][j] - 'A'] = true;
          ++selectedCount;
        } else if (map[i][j] == 'x') {
          arr.add(new Integer[] { i, j });
        }
      }
    }

    rec(0, selectedCount);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 5; ++i) {
      for (int j = 0; j < 9; ++j) {
        sb.append(result[i][j]);
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }

  private static void rec(int idx, int selectedCount) {
    if (isFinished)
      return;

    if (selectedCount == 12) {
      if (valueCheck()) {
        isFinished = true;
      }
      return;
    }

    for (int k = 0; k < 12 && !isFinished; ++k) {
      if (!visited[k]) {
        visited[k] = true;
        Integer[] pos = arr.get(idx);

        result[pos[0]][pos[1]] = (char) ('A' + k);
        rec(idx + 1, selectedCount + 1);
        visited[k] = false;
      }
    }
  }

  private static boolean valueCheck() {
    for (int i = 0; i < 6; ++i) {
      int val = 0;
      for (int j = 0; j < 4; ++j) {
        val += result[idxs[i][j][0]][idxs[i][j][1]] - 'A' + 1;
      }

      if (val != 26)
        return false;
    }
    return true;
  }
}
