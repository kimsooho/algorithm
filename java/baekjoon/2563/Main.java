import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    boolean[][] map = new boolean[100][100];
    int cnt = 0;
    for (int i = 0; i < N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      for (int posY = y; posY < y + 10; ++posY) {
        for (int posX = x; posX < x + 10; ++posX) {
          if(!map[posY][posX])
          {
            map[posY][posX] = true;
            ++cnt;
          }
        }
      }
    }

    System.out.println(cnt);
  }
}
