import java.util.Scanner;

/**
 * Solution
 */
public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();

    for(int t=1; t<=T; ++t)
    {
      int N = sc.nextInt();
      int M = sc.nextInt();

      int[][] map = new int[N][N];

      for(int i=0; i<N; ++i)
      {
        for(int j=0; j<N; ++j)
        {
          map[i][j] = sc.nextInt();
        }
      }

      int maxValue = -1;
      for(int i=0; i<N - M + 1; ++i)
      {        
        for(int j=0; j<N - M + 1; ++j)
        {
          int sum = 0;
          for(int m = 0; m<M; ++m)
          {
            for(int mm=0; mm<M; ++mm)
            {
              sum += map[i+m][j+mm];
            }
          }

          maxValue = Math.max(maxValue, sum);
        }
      }

      System.out.println(String.format("#%d %d", t , maxValue));
    }
  }
}