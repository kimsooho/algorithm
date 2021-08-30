
/**
 * @author suho kim
 * @no 3985
 * @title 롤 케이크
 * @url https://www.acmicpc.net/problem/3985
 * @date 2021.08.30
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int L = Integer.parseInt(br.readLine());
    int N = Integer.parseInt(br.readLine());

    boolean[] arr = new boolean[L + 1];
    int maxVal = -1;
    int maxVal2 = -1;
    int count = -1;
    int maxCount = -1;

    for (int i = 0; i < N; ++i) {
      int tmpCount = 0;
      st = new StringTokenizer(br.readLine());
      int P = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());

      if (K - P > maxCount) {
        maxCount = K - P;
        maxVal = i + 1;
      }

      for (int p = P; p <= K; ++p) {
        if (!arr[p])
          ++tmpCount;

        arr[p] = true;
      }

      if (tmpCount > count) {
        count = tmpCount;
        maxVal2 = i + 1;
      }
    }

    System.out.println(maxVal + "\n" + maxVal2);
  }
}
