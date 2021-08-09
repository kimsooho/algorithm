import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; ++t) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      
      int[] snacks = new int[N];
      for (int i = 0; i < N; ++i) {
        snacks[i] = Integer.parseInt(st.nextToken());
      }
      
      int result = -1;

      for(int i=0; i<snacks.length - 1; ++i)
      {
        for(int j=i+1; j<snacks.length; ++j)
        {
          int sum = snacks[i] + snacks[j];

          if(sum <= M)
            result = Math.max(result, sum);
        }
      }

      System.out.println(String.format("#%d %d", t, result));
    }
  }
}
