 /**
 * @author suho kim
 * @no 1238
 * @title [S/W 문제해결 기본] 10일차 - Contact
 * @date 2021.08.23
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class IndexCounter
{
  int idx;
  int count;
  public IndexCounter(int idx, int count)
  {
    this.idx = idx;
    this.count = count;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for(int t=1; t<=10; ++t)
    {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int idx = Integer.parseInt(st.nextToken());

      Queue<Integer> q = new LinkedList<Integer>();
      IndexCounter[] countArray = new IndexCounter[101];
      for(int i=0; i<101; ++i)
      {
        countArray[i] = new IndexCounter(i, 0);
      }
      ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
      
      for(int i=0; i<101; ++i)
        map.add(new ArrayList<Integer>());

      st = new StringTokenizer(br.readLine());

      for(int i=0; i<N/2; ++i)
      {
        map.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
      }

      q.offer(idx);
      ++countArray[idx].count;      
      countArray = bfs(q, map, countArray);

      Arrays.sort(countArray, new Comparator<IndexCounter>(){
        @Override
        public int compare(IndexCounter o1, IndexCounter o2) {
          if(o2.count == o1.count)
          {
            return o2.idx - o1.idx;
          }
          return o2.count - o1.count;
        }
        
      });

      System.out.println(String.format("#%d %d", t, countArray[0].idx));
    }
  }

  private static IndexCounter[] bfs(Queue<Integer> q, ArrayList<ArrayList<Integer>> map, IndexCounter[] countArray)
  {
    while(!q.isEmpty())
    {
      int from = q.poll();
      for(int i=0; i<map.get(from).size(); ++i)
      {
        if(countArray[map.get(from).get(i)].count == 0)
        {
          countArray[map.get(from).get(i)].count = countArray[from].count + 1;
          q.offer(map.get(from).get(i));
        }
      }
    }

    return countArray;
  }
}
