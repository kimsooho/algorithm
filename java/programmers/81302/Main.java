
/**
 * @author suho kim
 * @no 81302
 * @title 거리두기 확인하기
 * @url https://programmers.co.kr/learn/courses/30/lessons/81302
 * @date 2021.10.13
 */
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] result = s.solution(new String[][] { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
        { "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
        { "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } });

    System.out.println(Arrays.toString(result));
  }
}

class Solution {
  int[] moveRow = { 0, 0, 1, 1, 2, 1 };
  int[] moveCol = { 1, 2, -1, 0, 0, 1 };

  char[][][] map;

  int N;
  int H;
  int W;

  public int[] solution(String[][] places) {
    // check -> 앞 (1 2), 뒤 밑, 밑(1 2), 앞 밑 ->
    N = places.length;
    H = places[0].length;
    W = places[0][0].length();
    int[] answer = new int[N];
    map = new char[N][H][W];

    for (int n = 0; n < N; ++n) {
      for (int h = 0; h < H; ++h) {
        for (int w = 0; w < W; ++w) {
          map[n][h][w] = places[n][h].charAt(w);
        }
      }
    }

    for (int i = 0; i < N; ++i) {
      answer[i] = run(i) ? 1 : 0;
    }

    return answer;
  }

  private boolean run(int n) {
    for (int i = 0; i < H; ++i) {
      for (int j = 0; j < W; ++j) {
        if (map[n][i][j] == 'P') {
          if (!check(n, i, j)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  private boolean check(int n, int h, int w) {
    for (int i = 0; i < 6; ++i) {
      int nextRow = h + moveRow[i];
      int nextCol = w + moveCol[i];

      if (nextRow < 0 || nextRow >= H || nextCol < 0 || nextCol >= W)
        continue;

      if (i == 0 || i == 3) {
        if (map[n][nextRow][nextCol] == 'P')
          return false;

        if (map[n][nextRow][nextCol] == 'X') {
          ++i;
          continue;
        }
      }

      if ((i == 1 || i == 4) && map[n][nextRow][nextCol] == 'P')
        return false;

      if (i == 2 && map[n][nextRow][nextCol] == 'P'
          && (map[n][nextRow - 1][nextCol] != 'X' || map[n][nextRow][nextCol + 1] != 'X'))
        return false;

      if (i == 5 && map[n][nextRow][nextCol] == 'P'
          && (map[n][nextRow - 1][nextCol] != 'X' || map[n][nextRow][nextCol - 1] != 'X'))
        return false;

    }
    return true;
  }
}