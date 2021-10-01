
/**
 * @author suho kim
 * @no 17143
 * @title 낚시왕
 * @url https://www.acmicpc.net/problem/17143
 * @date 2021.10.01
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Shark {

  int dir;
  int speed;
  int size;

  public Shark(int speed, int dir, int size) {
    this.dir = dir;
    this.speed = speed;
    this.size = size;
  }

  public void reverse() {
    if (dir % 2 == 0) {
      --dir;
    } else {
      ++dir;
    }
  }
}

class Sharks {
  ArrayList<Shark> sharks;

  public Sharks() {
    sharks = new ArrayList<Shark>();
  }
}

public class Main {
  static int[] moveRow = { 0, -1, 1, 0, 0 };
  static int[] moveCol = { 0, 0, 0, 1, -1 };
  static Sharks[][] map;
  static int R;
  static int C;

  static int score;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    map = new Sharks[R][C];
    initMap(map);

    for (int i = 0; i < M; ++i) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      int z = Integer.parseInt(st.nextToken());

      map[r - 1][c - 1].sharks.add(new Shark(s, d, z));
    }
    score = 0;
    for (int i = 0; i < C; ++i) {
      eat();
      fishing(i);
      move();
    }

    System.out.println(score);
  }

  private static void initMap(Sharks[][] _map) {
    for (int i = 0; i < R; ++i) {
      for (int j = 0; j < C; ++j) {
        _map[i][j] = new Sharks();
      }
    }
  }

  private static void fishing(int idx) {
    for (int i = 0; i < R; ++i) {
      if (map[i][idx].sharks.size() > 0) {
        score += map[i][idx].sharks.get(0).size;
        map[i][idx].sharks.clear();
        return;
      }
    }
  }

  private static void move() {
    Sharks[][] tmpSharks = new Sharks[R][C];
    initMap(tmpSharks);

    for (int i = 0; i < R; ++i) {
      for (int j = 0; j < C; ++j) {
        for (Shark shark : map[i][j].sharks) {
          int r = i + (moveRow[shark.dir] * shark.speed);
          int c = j + (moveCol[shark.dir] * shark.speed);

          int rr = R - 1;
          int cc = C - 1;

          if (r < 0 || r >= R) {
            if (Math.abs(r) % (rr * 2) >= rr) {
              if (r >= R)
                shark.reverse();
              r = rr - (Math.abs(r) % rr);
            } else {
              if (r < 0)
                shark.reverse();
              r = (Math.abs(r) % rr);
            }
          }

          if (c < 0 || c >= C) {
            if (Math.abs(c) % (cc * 2) >= cc) {
              if (c >= C)
                shark.reverse();
              c = cc - Math.abs(c) % cc;
            } else {
              if (c < 0)
                shark.reverse();
              c = (Math.abs(c) % cc);
            }
          }
          tmpSharks[r][c].sharks.add(shark);
        }
      }
    }

    for (int i = 0; i < R; ++i) {
      for (int j = 0; j < C; ++j) {
        map[i][j].sharks = tmpSharks[i][j].sharks;
      }
    }
  }

  private static void eat() {
    for (int i = 0; i < R; ++i) {
      for (int j = 0; j < C; ++j) {
        ArrayList<Shark> sharks = map[i][j].sharks;
        sharks.sort(new Comparator<Shark>() {
          @Override
          public int compare(Shark o1, Shark o2) {
            return o2.size - o1.size;
          }
        });

        for (int s = sharks.size() - 1; s > 0; --s) {
          sharks.remove(s);
        }
      }
    }
  }
}
