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
  static int[][] map;
  static int N;
  static int M;
  static ArrayList<Pair> chickens;
  static ArrayList<Pair> houses;
  static Pair[] selected;

  static int result = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][N];

    chickens = new ArrayList<Pair>();
    houses = new ArrayList<Pair>();
    selected = new Pair[M];
    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 1) {
          houses.add(new Pair(j, i));
        } else if (map[i][j] == 2) {
          chickens.add(new Pair(j, i));
        }
      }
    }

    combination(0, 0);
    System.out.println(result);
  }

  private static void combination(int count, int start) {
    if (count == M) {
      int minValue = 0;
      for (int i = 0; i < houses.size(); ++i) {
        int dist = Integer.MAX_VALUE;
        for (int j = 0; j < selected.length; ++j) {
          dist = Math.min(Math.abs(houses.get(i).y - selected[j].y) + Math.abs(houses.get(i).x - selected[j].x),
              dist);
        }
        minValue += dist;
      }
      result = Math.min(result, minValue);
      return;
    }

    for (int i = start; i < chickens.size(); ++i) {
      selected[count] = chickens.get(i);
      combination(count + 1, i + 1);
    }
  }
}
