/**
 * @author suho kim
 * @title 빵집
 * @url https://www.acmicpc.net/problem/3109 
 * @date 2021.08.19
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] moveRow = {-1, 0, 1};
  static int[] moveCol = {1, 1, 1};

  static int R;
  static int C;

  static char[][] map;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new char[R][C];

    for(int r=0; r<R; ++r)
    {
      map[r] = br.readLine().toCharArray();
    }

    int count = 0;
    for(int r=0; r<R; ++r)
    {
      count += dfs(r, 0);
    }
    System.out.println(count);
  }

  private static int dfs(int r, int c)
  {
    if(c == C-1)
    {
      return 1;
    }

    map[r][c] = 'X';
    for(int i=0; i<3; ++i)
    {
      int nextRow = r + moveRow[i];
      int nextCol = c + moveCol[i];

      if(nextRow < 0 || nextRow >= R || nextCol >= C || map[nextRow][nextCol] != '.')
      {
        continue;
      }

      if(dfs(nextRow, nextCol) == 1 ) return 1;
    }
    
    return 0;
  }
}
