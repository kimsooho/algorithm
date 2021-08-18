import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] map;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    sb = new StringBuilder();

    int N = Integer.parseInt(st.nextToken());
    map = new int[N][N];

    for (int i = 0; i < N; ++i) {
      String line = br.readLine();
      for (int j = 0; j < N; ++j) {
        map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
      }
    }

    quadTree(0, 0, N);
    System.out.println(sb);
  }

  private static void quadTree(int r, int c, int size) {
    if (isValidPixel(r, c, size)) {
      sb.append(Integer.toString(map[r][c]));
      return;
    }

    int harf = size / 2;
    sb.append("(");
    quadTree(r, c, harf);
    quadTree(r, c + harf, harf);
    quadTree(r + harf, c, harf);
    quadTree(r + harf, c + harf, harf);
    sb.append(")");
  }

  private static boolean isValidPixel(int r, int c, int size) {
    int pixel = map[r][c];

    for (int i = r; i < r + size; ++i) {
      for (int j = c; j < c + size; ++j) {
        if (pixel != map[i][j])
          return false;
      }
    }
    return true;
  }
}
