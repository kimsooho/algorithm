import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  static int N = 9;
  static int[] cardsA;
  static int[] cardsB;
  static int[] perm;
  static int winCount;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; ++t) {
      cardsA = new int[N];
      cardsB = new int[N];
      winCount = 0;
      boolean[] checked = new boolean[N * 2];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; ++i) {
        cardsA[i] = Integer.parseInt(st.nextToken());
        checked[cardsA[i] - 1] = true;
      }

      for (int i = 0, idx = 0; i < N * 2; ++i) {
        if (checked[i] == false) {
          cardsB[idx++] = i + 1;
        }
      }

      perm = new int[N];
      permutation(0, 0);
      System.out.println(String.format("#%d %d %d", t, winCount, 362880 - winCount));
    }
    
  }

  private static void permutation(int count, int flag) {
    if (count == N) {
      int scoreA = 0;
      int scoreB = 0;
      for (int i = 0; i < N; ++i) {
        if (cardsA[i] > perm[i]) {
          scoreA += cardsA[i] + perm[i];
        } else {
          scoreB += cardsA[i] + perm[i];
        }
      }

      if (scoreA > scoreB)
        ++winCount;

      return;
    }

    for (int i = 0; i < N; ++i) {
      if ((flag & 1 << i) != 0)
        continue;

      perm[count] = cardsB[i];

      permutation(count + 1, flag | 1 << i);
    }
  }
}
