import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
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
  static int N;
  static int M;
  static int D;

  static Queue<Pair> q;

  static int[][] originalMap;
  static int[][] copyMap;
  static boolean[][] isVisited;
  static boolean[][] isKilled;

  static int[] selectedIndex;

  static int[] axisX = { -1, 0, 1 };
  static int[] axisY = { 0, -1, 0 };

  static int maxValue = Integer.MIN_VALUE;
  static int tmpValue = Integer.MIN_VALUE;

  static ArrayList<Pair> shootInfo = new ArrayList<Pair>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    selectedIndex = new int[3];
    q = new LinkedList<Pair>();

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());

    originalMap = new int[N + 1][M];
    copyMap = new int[N + 1][M];
    isVisited = new boolean[N + 1][M];
    isKilled = new boolean[N+1][M];
    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; ++j) {
        originalMap[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    Arrays.fill(originalMap[N], 0);

    combination(0, 0);
    System.out.println(maxValue);
  }

  private static void combination(int count, int start) {
    if (count == 3) {
      copyMap();
      tmpValue = 0;
      for (int idx = 0; idx < isKilled.length; ++idx) {
        Arrays.fill(isKilled[idx], false);
      }
      for (int archerIdx = N; archerIdx > 0; --archerIdx) {
        shootInfo.clear();
        for (int i = 0; i < 3; ++i) {
          for (int idx = 0; idx < isVisited.length; ++idx) {
            Arrays.fill(isVisited[idx], false);
          }
          q.offer(new Pair(selectedIndex[i], archerIdx));
          bfs(archerIdx);
        }
        for (Pair pair : shootInfo) {
          copyMap[pair.y][pair.x] = 0;
        }
      }
      maxValue = Math.max(maxValue, tmpValue);

      return;
    }

    for (int i = start; i < M; ++i) {
      selectedIndex[count] = i;
      combination(count + 1, i + 1);
    }
  }

  private static void bfs(int moveIdx) {
    int archerY = q.peek().y;
    int archerX = q.peek().x;
    isVisited[archerY][archerX] = true;
    while (!q.isEmpty()) {
      int y = q.peek().y;
      int x = q.peek().x;
      q.poll();

      for (int i = 0; i < 3; ++i) {
        int nextY = axisY[i] + y;
        int nextX = axisX[i] + x;
        if (nextY >= moveIdx || nextY < 0 || nextX >= M || nextX < 0 || isVisited[nextY][nextX]
            || getDistance(new Pair(archerX, archerY), new Pair(nextX, nextY)) > D) {
          continue;
        }
        if (copyMap[nextY][nextX] == 1) {
          if(!isKilled[nextY][nextX])
          {
            isKilled[nextY][nextX] = true;
            ++tmpValue;
          }
          shootInfo.add(new Pair(nextX, nextY));
          q.clear();
          break;
        } else {
          q.offer(new Pair(nextX, nextY));
        }

        isVisited[nextY][nextX] = true;
      }
    }
  }

  private static int getDistance(Pair pairA, Pair pairB) {
    return Math.abs(pairA.y - pairB.y) + Math.abs(pairA.x - pairB.x);
  }

  private static void copyMap() {
    for (int i = 0; i < originalMap.length; ++i) {
      for (int j = 0; j < originalMap[i].length; ++j) {
        copyMap[i][j] = originalMap[i][j];
      }
    }
  }
}
