import java.util.Scanner;

/**
 * Solution
 */
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();

    for (int t = 1; t <= T; ++t) {
      int N = sc.nextInt();
      int[][] map = new int[N][N];

      int num = 1;
      int indexY = -1;
      int indexX = -1;
      while (num <= N * N) {
        for (++indexY, ++indexX; indexX < N && map[indexY][indexX] == 0; ++indexX)
          map[indexY][indexX] = num++;
        
        for (++indexY, --indexX; indexY < N && map[indexY][indexX] == 0; ++indexY)
          map[indexY][indexX] = num++;          
        
        for (--indexY, --indexX; indexX >= 0 && map[indexY][indexX] == 0; --indexX)
          map[indexY][indexX] = num++;

        for (--indexY, ++indexX; indexY >= 0 && map[indexY][indexX] == 0; --indexY)
          map[indexY][indexX] = num++;
      }

      System.out.println(String.format("#%d", t));
      for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
          System.out.print(String.format("%d ", map[i][j]));
        }
        System.out.println();
      }
    }
  }
}