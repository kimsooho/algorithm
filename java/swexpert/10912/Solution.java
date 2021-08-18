import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for(int t=1; t<=T; ++t)
    {
      ArrayList<String> arrStr = new ArrayList<String>();
      HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
      String line = br.readLine();

      for(int i=0; i<line.length(); ++i)
      {
        String str = String.valueOf(line.charAt(i));
        if(!hashMap.containsKey(str))
        {
          hashMap.put(str, 0);
        }

        hashMap.replace(str, hashMap.get(str)+1);
      }

      for(String key : hashMap.keySet())
      {
        if(hashMap.get(key) % 2 != 0)
        {
          arrStr.add(key);
        }
      }

      Collections.sort(arrStr);
      StringBuilder sb = new StringBuilder();
      for(String s : arrStr)
      {
        sb.append(s);
      }
      
      System.out.println(String.format("#%d %s", t, arrStr.isEmpty() ? "Good" : sb));
    }
  }
}
