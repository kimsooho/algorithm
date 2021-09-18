
/**
 * @author suho kim
 * @no 1236
 * @title 성 지키기
 * @url https://www.acmicpc.net/problem/1236
 * @date 2021.09.18
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    boolean[] row = new boolean[N];
    boolean[] col = new boolean[M];

    for (int i = 0; i < N; ++i) {
      String line = br.readLine();
      for (int j = 0; j < line.length(); ++j) {
        if (line.charAt(j) == 'X') {
          row[i] = true;
          col[j] = true;
        }
      }
    }

    int rowCount = 0;
    for (int i = 0; i < N; ++i) {
      if (!row[i]) {
        ++rowCount;
      }
    }

    int colCount = 0;
    for (int i = 0; i < M; ++i) {
      if (!col[i]) {
        ++colCount;
      }
    }

    System.out.println(Math.max(rowCount, colCount));
  }
}
