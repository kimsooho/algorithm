/**
 * @author suho kim
 * @title [SWexpert - [S/W 문제해결 응용] 최적 경로]
 * @url https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD&categoryId=AV15OZ4qAPICFAYD&categoryType=CODE&problemTitle=1247&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @date 2021.08.19
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pair
{
  int x;
  int y;
  public Pair(int x, int y)
  {
    this.x = x;
    this.y = y;    
  }
}

public class Solution {
  static int minValue;
  static Pair pCompany;
  static Pair pHouse;
  static Pair[] pairs;
  static Pair[] perm;
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());

    for(int t=1; t<=T; ++t)
    {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      pCompany = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      pHouse = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      
      pairs = new Pair[N];
      perm = new Pair[N];

      minValue = Integer.MAX_VALUE;

      for(int i=0; i<N; ++i)
      {
        pairs[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));        
      }

      permutation(0, 0);
      System.out.println(String.format("#%d %d", t, minValue));
    }
  }

  private static void permutation(int count, int flag)
  {
    if(count == N)
    {
      int value = 0;
      Pair prev = pCompany;
      for(int i=0; i<N; ++i)
      {
        value += getDistance(prev, perm[i]);
        if(value >= minValue) break; // 가지치기
        prev = perm[i];
      }

      value += getDistance(prev, pHouse);
      minValue = Math.min(minValue, value);
      return;
    }

    for (int i = 0; i < N; ++i) {
      if ((flag & 1 << i) != 0)
        continue;

      perm[count] = pairs[i];

      permutation(count + 1, flag | 1 << i);
    }
  }

  private static int getDistance(Pair p1, Pair p2)
  {
    return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
  }
}
