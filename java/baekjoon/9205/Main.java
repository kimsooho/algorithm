
/**
 * @author suho kim
 * @no 9205
 * @title 맥주 마시면서 걸어가기
 * @url https://www.acmicpc.net/problem/9205
 * @date 2021.09.16
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pair {
  int x;
  int y;

  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int t = Integer.parseInt(st.nextToken());
    while (t-- > 0) {
      st = new StringTokenizer(br.readLine());
      int market = Integer.parseInt(st.nextToken());
      int[][] map = new int[market + 2][market + 2];
      ArrayList<Pair> datas = new ArrayList<Pair>();

      for (int i = 0; i < market + 2; ++i) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        datas.add(new Pair(x, y));
      }

      for (int i = 0; i < market + 2; ++i) {
        for (int j = 0; j < market + 2; ++j) {
          if (i != j) {
            map[i][j] = Integer.MAX_VALUE / 2;
          }
        }
      }

      for (int i = 0; i < market + 2; ++i) {
        for (int j = 0; j < market + 2; ++j) {
          if (i != j && isSafe(datas.get(i), datas.get(j))) {
            map[i][j] = 1;
          }
        }
      }

      for (int via = 0; via < market + 2; ++via) {
        for (int from = 0; from < market + 2; ++from) {
          for (int to = 0; to < market + 2; ++to) {
            map[from][to] = Math.min(map[from][to], map[from][via] + map[via][to]);
          }
        }
      }

      if (map[0][map[0].length - 1] < Integer.MAX_VALUE / 2) {
        System.out.println("happy");
      } else {
        System.out.println("sad");
      }
    }
  }

  private static boolean isSafe(Pair p1, Pair p2) {
    return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y) <= 1000;
  }
}