/**
 * @author suho kim
 * @no 1759
 * @title 암호 만들기
 * @url https://www.acmicpc.net/problem/1759
 * @date 2021.08.23
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static char[] arr;
  static boolean[] selected;

  static int L;
  static int C;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    arr = new char[C];

    st = new StringTokenizer(br.readLine());
    for(int i=0; i<C; ++i)
    {
      arr[i] = st.nextToken().charAt(0);
    }

    Arrays.sort(arr);
    selected = new boolean[C];
    
    dfs(0, 0, "");
  }
  
  private static void dfs(int idx, int count, String str)
  {
    if(count == L)
    {
      int moCount = 0;
      int jaCount = 0;

      for(int i=0; i<L; ++i)
      {
        char c = str.charAt(i);
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
          ++moCount;
        else
          ++jaCount;
      }

      if(moCount >= 1 && jaCount >= 2)
        System.out.println(str);
      return;
    }

    for(int i=idx; i<C; ++i)
    {
      if(!selected[i])
      {
        selected[i] = true;
        dfs(i + 1, count + 1, str + arr[i]);
        selected[i] = false;
      }
    }
  }
}
