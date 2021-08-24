 /**
 * @author suho kim
 * @no 3289
 * @title 서로소 집합
 * @date 2021.08.24
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  static int[] root;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());
    for(int t=1; t<=T; ++t)
    {
      StringBuilder sb = new StringBuilder();

      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      root = new int[n+1];
      for(int i=1; i<n+1; ++i)
      {
        root[i] = i;
      }

      for(int i=0; i<m; ++i)
      {
        st = new StringTokenizer(br.readLine());
        int cmd = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(cmd == 0)
        {
          union(a, b);
        }
        else
        {
          sb.append(isUnion(a, b) ? "1" : "0");
        }
      }


      System.out.println(String.format("#%d %s", t, sb));
    }
  }

  private static boolean isUnion(int a, int b)
  {
    int rootA = getRoot(a);
    int rootB = getRoot(b);

    return rootA == rootB;
  }

  private static void union(int a, int b)
  {
    int rootA = getRoot(a);
    int rootB = getRoot(b);

    root[rootB] = rootA;
  }

  private static int getRoot(int n)
  {
    if(n == root[n])
    {
      return n;
    }

    return root[n] = getRoot(root[n]);
  }
}
