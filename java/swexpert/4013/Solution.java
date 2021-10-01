
/**
* @author suho kim
* @no 4013
* @title 특이한 자석
* @date 2021.10.01
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  static int[][] gear;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; ++t) {
      int score = 0;
      int K = Integer.parseInt(br.readLine());

      gear = new int[4][8];

      for (int i = 0; i < 4; ++i) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < 8; ++j) {
          gear[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      for (int k = 0; k < K; ++k) {
        st = new StringTokenizer(br.readLine());
        int idx = Integer.parseInt(st.nextToken()) - 1;
        int rotate = Integer.parseInt(st.nextToken());
        int[] arrRotate = new int[4];
        arrRotate[idx] = rotate;
        for (int i = idx - 1; i >= 0; --i) {
          if (gear[i + 1][6] == gear[i][2]) {
            break;
          }
          arrRotate[i] = arrRotate[i + 1] * -1;
        }

        for (int i = idx + 1; i < 4; ++i) {
          if (gear[i - 1][2] == gear[i][6]) {
            break;
          }

          arrRotate[i] = arrRotate[i - 1] * -1;
        }
        for (int i = 0; i < 4; ++i) {
          if (arrRotate[i] != 0)
            rotate(i, arrRotate[i]);
        }
      }

      for (int i = 0; i < 4; ++i) {
        score += (1 << i) * gear[i][0];
      }

      System.out.println(String.format("#%d %d", t, score));
    }
  }

  private static void rotate(int idx, int rotate) {
    if (rotate == 1) {
      int tmp = gear[idx][7];
      for (int i = 7; i >= 1; --i) {
        gear[idx][i] = gear[idx][i - 1];
      }
      gear[idx][0] = tmp;
    } else {
      int tmp = gear[idx][0];
      for (int i = 0; i < 7; ++i) {
        gear[idx][i] = gear[idx][i + 1];
      }
      gear[idx][7] = tmp;
    }
  }
}
