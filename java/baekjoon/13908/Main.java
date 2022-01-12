
/**
 * @author suho kim
 * @no 13908
 * @title 비밀번호
 * @url https://www.acmicpc.net/problem/13908
 * @date 2022.01.12
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static boolean[] necessaryNum;
  static int N;
  static int M;
  static int result;
  static int[] selectedNumber;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    selectedNumber = new int[N];
    necessaryNum = new boolean[10];
    if (M != 0) {
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < M; ++i) {
        int num = Integer.parseInt(st.nextToken());
        necessaryNum[num] = true;
      }
    }

    com(0, 0);
    System.out.println(result);
  }

  private static void com(int depth, int containsCount) {
    if (depth == N) {
      if (containsCount == M) {
        ++result;
      }

      return;
    }

    for (int i = 0; i <= 9; ++i) {
      selectedNumber[depth] = i;
      if (necessaryNum[i]) {
        necessaryNum[i] = false;
        com(depth + 1, containsCount + 1);
        necessaryNum[i] = true;
      } else {
        com(depth + 1, containsCount);
      }
    }
  }
}