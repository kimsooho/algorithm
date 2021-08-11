import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] originalMap;
  static int N;
  static int M;
  static int[][] commands;

  static int[] axisX = { 1, 0, -1, 0 };
  static int[] axisY = { 0, 1, 0, -1 };

  static int minValue = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    
    originalMap = new int[N][M];
    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; ++j) {        
        originalMap[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    commands = new int[K][3];
    for (int k = 0; k < K; ++k) {
      st = new StringTokenizer(br.readLine());

      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());

      commands[k][0] = r;
      commands[k][1] = c;
      commands[k][2] = s;
    }

    int[] arrIndex = new int[K];
    for(int i=0; i<K; ++i)
    {
      arrIndex[i] = i;
    }

    permutation(arrIndex, 0, K);

    System.out.println(minValue);
  }

  static void permutation(int[] arr, int idx, int maxIndex) {
    if (idx == maxIndex) {
      int[][] map = new int[N][M];

      for(int i=0; i<N; ++i)
      {
        for(int j=0; j<M; ++j)
        {
          map[i][j] = originalMap[i][j];
        }
      }

      for (int i : arr) {
        int r = commands[i][0];
        int c = commands[i][1];
        int s = commands[i][2];

        int range = s;

        for (int rg = 0; rg < range; ++rg) {
          int x = c - s + rg - 1;
          int y = r - s + rg - 1;

          int prevData = map[y][x];
          int dir = 0;
          while (dir < 4) {
            int nextY = y + axisY[dir];
            int nextX = x + axisX[dir];
            if (nextY < r - s - 1 + rg || nextY >= r + s - rg || nextX < c - s - 1 + rg || nextX >= c + s - rg) {
              ++dir;
            } else {
              int temp = map[nextY][nextX];
              map[nextY][nextX] = prevData;
              prevData = temp;
              y = nextY;
              x = nextX;
            }
          }
        }
      }

      for (int i = 0; i < N; ++i) {
        int value = 0;
        for (int j = 0; j < M; ++j) {
          value += map[i][j];
        }
        minValue = Math.min(minValue, value);
      }
    }

    for (int i = idx; i < maxIndex; i++) {
      swap(arr, idx, i);
      permutation(arr, idx + 1, maxIndex);
      swap(arr, idx, i);
    }
  }

  static void swap(int[] arr, int idx, int i) {
    int temp = arr[idx];
    arr[idx] = arr[i];
    arr[i] = temp;
  }
}