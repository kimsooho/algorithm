import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Info {
  int value;
  int cal;

  public Info(int value, int cal) {
    this.value = value;
    this.cal = cal;
  }
}

public class Solution {

  private static int L;
  private static int N;
  private static int result;
  private static Info[] info;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; ++t) {
      result = 0;
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      L = Integer.parseInt(st.nextToken());

      info = new Info[N];
      
      for (int n = 0; n < N; ++n) {
        st = new StringTokenizer(br.readLine());
        int val = Integer.parseInt(st.nextToken());
        int cal = Integer.parseInt(st.nextToken());
        info[n] = new Info(val, cal);
      }

      recursive(0, 0, 0);

      System.out.println(String.format("#%d %d", t, result));
    }
  }

  private static void recursive(int cnt, int value, int cal) {
    if (cal > L)
      return;

    if (cnt == N) {
      result = Math.max(result, value);
      return;
    }
    
    recursive(cnt + 1, info[cnt].value + value, info[cnt].cal + cal);
    recursive(cnt + 1, value, cal);
  }
}
