import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    String[][] map = new String[R + 1][C + 1];

    for (int r = 1; r < R + 1; ++r) {
      String row = br.readLine();
      for (int c = 1; c < C + 1; ++c) {
        map[r][c] = String.valueOf(row.charAt(c - 1));
      }
    }

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      int posCol = Integer.parseInt(st.nextToken());
      int nextRow = 0;
      int nextCol = posCol;

      while (true) {
        int tmpRow = nextRow + 1;
        int tmpCol = nextCol;
        

        if (tmpRow < 1 || tmpRow > R || map[tmpRow][tmpCol].equals("X")) {
          map[nextRow][tmpCol] = "O";
          break;
        }

        if (map[tmpRow][tmpCol].equals("O")) {
          int leftCol = tmpCol - 1;
          int rightCol = tmpCol + 1;
          if (leftCol > 0 && map[nextRow][leftCol].equals(".") && map[tmpRow][leftCol].equals(".")) 
          {
            nextCol = leftCol;
          } 
          else if (rightCol < C + 1 && map[nextRow][rightCol].equals(".") && map[tmpRow][rightCol].equals(".")) 
          {
            nextCol = rightCol;
          } 
          else 
          {
            map[nextRow][tmpCol] = "O";
            break;
          }

        }
        nextRow = tmpRow;
      }
    }

    for (int r = 1; r < R + 1; ++r) {
      for (int c = 1; c < C + 1; ++c) {
        sb.append(map[r][c]);
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

}
