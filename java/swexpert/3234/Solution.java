 /**
 * @author suho kim
 * @no 3234
 * @title 준환이의 양팔저울 
 * @date 2021.08.23
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  static int result;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());

    for(int t=1; t<=T; ++t)
    {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int[] weights = new int[N];
      boolean[] selected = new boolean[N];
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<N; ++i)
      {
        weights[i] = Integer.parseInt(st.nextToken());
      }

      result = 0;      
      dfs(weights, selected, N, 0,0,0);
      System.out.println(String.format("#%d %d", t, result));
    }
  }

  private static void dfs(int[] weights, boolean[] selected, int N, int count, int weightL, int weightR)
  {
    if(count == N)
    {
      ++result;
      return;
    }

    for(int i=0; i<N; ++i)
    {
      if(!selected[i])
      {
        selected[i] = true;
        dfs(weights, selected, N, count + 1, weightL + weights[i], weightR);
        if(weightL >= weightR + weights[i])
          dfs(weights, selected, N, count + 1, weightL, weightR + weights[i]);
        selected[i] = false;
      }
    }
  }
}
