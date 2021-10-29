
/**
 * @author suho kim
 * @no 17142
 * @title 연구소 3
 * @url https://www.acmicpc.net/problem/17142
 * @date 2021.10.29
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

public class Main {
  static int N;
  static int M;

  static int[] moveRow = { -1, 1, 0, 0 };
  static int[] moveCol = { 0, 0, -1, 1 };

  static int[][] map;
  static Pair[] output;
  static List<Pair> viruss;
  static boolean[] visited;

  static int result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][N];
    viruss = new ArrayList<Pair>();
    output = new Pair[M];
    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 2) {
          viruss.add(new Pair(i, j));
        }
      }
    }

    visited = new boolean[viruss.size()];
    result = Integer.MAX_VALUE;

    com(0, 0);
    System.out.println(result == Integer.MAX_VALUE ? -1 : result);
  }

  private static void com(int idx, int depth) {
    if (depth == M) {
      result = Math.min(result, sol());
      return;
    }

    for (int i = idx; i < viruss.size(); ++i) {
      if (!visited[i]) {
        visited[i] = true;
        output[depth] = viruss.get(i);
        com(i + 1, depth + 1);
        visited[i] = false;
      }
    }
  }

  private static int sol() {
    int retVal = 0;
    int zeroCount = 0;
    int[][] copy = new int[N][N];
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        if (map[i][j] == 1) {
          copy[i][j] = -2;
        } else {
          if (map[i][j] == 0) {
            ++zeroCount;
          }
          copy[i][j] = -1;
        }
      }
    }

    Queue<Pair> q = new LinkedList<Pair>();
    for (Pair pair : output) {
      q.offer(pair);
      copy[pair.row][pair.col] = 0;
    }

    while (!q.isEmpty()) {
      Pair pair = q.poll();

      for (int i = 0; i < 4; ++i) {
        int nextRow = pair.row + moveRow[i];
        int nextCol = pair.col + moveCol[i];

        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N || copy[nextRow][nextCol] != -1)
          continue;

        if (zeroCount == 0) {
          break;
        }
        if (map[nextRow][nextCol] == 0)
          --zeroCount;
        copy[nextRow][nextCol] = copy[pair.row][pair.col] + 1;
        retVal = Math.max(retVal, copy[nextRow][nextCol]);
        q.offer(new Pair(nextRow, nextCol));
      }
    }

    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        if (copy[i][j] == -1 && zeroCount != 0) {
          return Integer.MAX_VALUE;
        }
      }
    }
    return retVal;
  }
}
