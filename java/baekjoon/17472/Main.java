
/**
 * @author suho kim
 * @no 17472
 * @title 다리 만들기 2
 * @url https://www.acmicpc.net/problem/17472
 * @date 2021.09.20
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
  int row;
  int col;

  public Pair(int row, int col) {
    this.row = row;
    this.col = col;
  }
}

class Info implements Comparable<Info> {
  int v;
  int weight;

  public Info(int v, int weight) {
    this.v = v;
    this.weight = weight;
  }

  @Override
  public int compareTo(Info o) {
    return this.weight - o.weight;
  }
}

public class Main {
  static int[] moveRow = { -1, 1, 0, 0 };
  static int[] moveCol = { 0, 0, -1, 1 };

  static int[][] map;
  static ArrayList<ArrayList<Pair>> area;

  static boolean[] bridge;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    area = new ArrayList<ArrayList<Pair>>();
    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken()) * -1;
      }
    }

    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < M; ++j) {
        if (map[i][j] == -1)
          bfs(i, j);
      }
    }

    ArrayList<ArrayList<Info>> bridgeInfo = new ArrayList<ArrayList<Info>>();
    for (int i = 0; i < area.size(); ++i) {
      bridgeInfo.add(new ArrayList<Info>());
    }

    for (int i = 0; i < area.size(); ++i) {
      for (Pair pair : area.get(i)) {
        addBridge(bridgeInfo, i, pair);
      }
    }

    if (!buildable(bridgeInfo)) {
      System.out.println(-1);
    } else {
      bridge = new boolean[area.size()];
      System.out.println(getMinWeight(bridgeInfo));
    }
  }

  private static void addBridge(ArrayList<ArrayList<Info>> bridgeInfo, int from, Pair pair) {
    for (int i = 0; i < 4; ++i) {
      int nextRow = moveRow[i] + pair.row;
      int nextCol = moveCol[i] + pair.col;
      int length = 0;
      int to = -1;
      while (nextRow >= 0 && nextRow < map.length && nextCol >= 0 && nextCol < map[0].length) {
        if (map[nextRow][nextCol] != 0) {
          to = map[nextRow][nextCol];
          break;
        }
        ++length;

        nextRow += moveRow[i];
        nextCol += moveCol[i];
      }

      if (length >= 2 && to != -1) {
        bridgeInfo.get(from).add(new Info(to - 1, length));
      }
    }
  }

  private static void bfs(int row, int col) {
    area.add(new ArrayList<Pair>());

    Queue<Pair> q = new LinkedList<Pair>();
    q.offer(new Pair(row, col));
    map[row][col] = area.size();

    while (!q.isEmpty()) {
      Pair pair = q.poll();
      area.get(area.size() - 1).add(pair);
      for (int i = 0; i < 4; ++i) {
        int nextRow = moveRow[i] + pair.row;
        int nextCol = moveCol[i] + pair.col;

        if (nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[0].length
            || map[nextRow][nextCol] != -1)
          continue;

        q.offer(new Pair(nextRow, nextCol));
        map[nextRow][nextCol] = area.size();
      }
    }
  }

  private static int getMinWeight(ArrayList<ArrayList<Info>> bridgeInfo) {
    boolean[] visited = new boolean[bridgeInfo.size()];
    PriorityQueue<Info> pq = new PriorityQueue<Info>();
    pq.offer(new Info(0, 0));

    int weight = 0;
    while (!pq.isEmpty()) {
      Info info = pq.poll();

      if (visited[info.v])
        continue;

      visited[info.v] = true;
      weight += info.weight;
      for (Info _info : bridgeInfo.get(info.v)) {
        if (!visited[_info.v])
          pq.offer(_info);
      }
    }
    return weight;
  }

  private static boolean buildable(ArrayList<ArrayList<Info>> bridgeInfo) {
    boolean[] buildable = new boolean[bridgeInfo.size()];
    Queue<Integer> q = new LinkedList<Integer>();
    buildable[0] = true;
    q.offer(0);

    while (!q.isEmpty()) {
      int v = q.poll();

      for (Info info : bridgeInfo.get(v)) {
        if (!buildable[info.v]) {
          q.offer(info.v);
          buildable[info.v] = true;
        }
      }
    }

    boolean isBuildable = true;
    for (int i = 0; i < buildable.length; ++i) {
      isBuildable &= buildable[i];
    }

    return isBuildable;
  }
}
