
/**
 * @author suho kim
 * @no 6603
 * @title 로또
 * @url https://www.acmicpc.net/problem/6603
 * @date 2021.11.16
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int[] numbers;
  static int[] chosen;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    chosen = new int[6];
    while (true) {
      sb = new StringBuilder();
      StringTokenizer st = new StringTokenizer(br.readLine());
      int K = Integer.parseInt(st.nextToken());
      if (K == 0)
        break;
      numbers = new int[K];
      for (int i = 0; i < K; ++i) {
        numbers[i] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(numbers);
      run(0, 0);
      System.out.println(sb);
    }
  }

  private static void run(int idx, int depth) {
    if (depth == 6) {
      for (int num : chosen) {
        sb.append(num + " ");
      }
      Arrays.toString(chosen);
      sb.append("\n");
      return;

    }

    for (int i = idx; i < numbers.length; ++i) {
      chosen[depth] = numbers[i];
      run(i + 1, depth + 1);
    }
  }
}