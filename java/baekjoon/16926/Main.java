import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    int[] axisX = {0, 1, 0, -1};
    int[] axisY = {1, 0, -1, 0};

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());

    int[][] map = new int[N][M];
    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int range = (Math.min(N, M)) / 2;

    for (int rg = 0; rg < range; ++rg) 
    {
      for (int r = 0; r < R; ++r) 
      {
        int x = rg;
        int y = rg;

        int prevData = map[y][x];

        int dir = 0;
        while(dir < 4)
        {
          int nextY = y + axisY[dir];
          int nextX = x + axisX[dir];
          if(nextY < rg || nextY >= N-rg || nextX < rg || nextX >= M - rg)
          {
            ++dir;
          }
          else
          {
            int temp = map[nextY][nextX];
            map[nextY][nextX] = prevData;
            prevData = temp;
            y = nextY;
            x = nextX;
          }
        }
      }
    }
    
    for(int i=0; i<N; ++i)
    {
      for(int j=0; j<M; ++j)
      {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
  }
}
