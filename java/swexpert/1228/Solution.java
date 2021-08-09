import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    for(int t=1; t<=10; ++t)
    {
      ArrayList<Integer> encryption = new ArrayList<Integer>();
      int N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=0; i<N; ++i)
      {
        int e = Integer.parseInt(st.nextToken());
        encryption.add(e);
      }
      
      int cmdN = Integer.parseInt(br.readLine());
      String[] cmds = br.readLine().split("I");

      for(int i=1; i<cmds.length; ++i)
      {
        st = new StringTokenizer(cmds[i]);
        int insertIdx = Integer.parseInt(st.nextToken().trim());
        int insertCnt = Integer.parseInt(st.nextToken().trim());

        for(int j=0; j<insertCnt; ++j)
        {
          encryption.add(insertIdx + j, Integer.parseInt(st.nextToken()));
        }
      }

      StringBuilder sb = new StringBuilder();
      sb.append(String.format("#%d ", t));

      for(int i=0; i<10; ++i)
      {
        sb.append(String.format("%d ", encryption.get(i)));
      }

      System.out.println(sb);
    }
  }
  
}
