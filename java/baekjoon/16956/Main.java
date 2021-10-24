
/**
 * @author suho kim
 * @no 16956
 * @title 늑대와 양
 * @url https://www.acmicpc.net/problem/16956
 * @date 2021.10.24
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

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] moveRow = { -1, 1, 0, 0 };
    int[] moveCol = { 0, 0, -1, 1 };
    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    char[][] map = new char[R][C];

    ArrayList<Pair> wolfs = new ArrayList<Pair>();

    for (int i = 0; i < R; ++i) {
      String line = br.readLine();
      for (int j = 0; j < C; ++j) {
        map[i][j] = line.charAt(j);
        if (map[i][j] == 'W') {
          wolfs.add(new Pair(i, j));
        }
      }
    }

    for (Pair pair : wolfs) {
      for (int i = 0; i < 4; ++i) {
        int nextRow = pair.row + moveRow[i];
        int nextCol = pair.col + moveCol[i];

        if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C || map[nextRow][nextCol] == 'W'
            || map[nextRow][nextCol] == 'D')
          continue;

        if (map[nextRow][nextCol] == 'S') {
          System.out.println(0);
          return;
        }

        map[nextRow][nextCol] = 'D';
      }
    }

    System.out.println(1);
    for (int i = 0; i < R; ++i) {
      for (int j = 0; j < C; ++j) {
        System.out.print(map[i][j]);
      }
      System.out.println();
    }
  }
}
