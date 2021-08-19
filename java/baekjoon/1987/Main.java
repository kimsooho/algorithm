
/**
 * @author suho kim
 * @title BJ 알파벳
 * @url https://www.acmicpc.net/problem/1987
 * @date 2021.08.19
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Element {
  int r;
  int c;
  char data;

  public Element(int r, int c, char data) {
    this.r = r;
    this.c = c;
    this.data = data;
  }
}

public class Main {
  static int R;
  static int C;

  static Element[][] map;
  static boolean[] visited;

  static int[] moveRow = { 0, 0, -1, 1 };
  static int[] moveCol = { -1, 1, 0, 0 };

  static int maxValue;
  static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new Element[R][C];
    visited = new boolean[26];

    maxValue = 0;
    count = 0;

    for (int r = 0; r < R; ++r) {
      String line = br.readLine();
      for (int c = 0; c < C; ++c) {
        map[r][c] = new Element(r, c, line.charAt(c));
      }
    }

    dfs(map[0][0]);
    System.out.println(maxValue);
  }

  private static void dfs(Element e) {
    visited[e.data - 'A'] = true;
    ++count;
    for (int i = 0; i < 4; ++i) {
      int nextRow = e.r + moveRow[i];
      int nextCol = e.c + moveCol[i];

      if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C/* || visited[map[nextRow][nextCol].data] */) {
        continue;
      }
      Element nextElement = map[nextRow][nextCol];
      if (!visited[nextElement.data - 'A']) {
        dfs(nextElement);
      }
    }
    maxValue = Math.max(maxValue, count--);
    visited[e.data - 'A'] = false;
  }
}
