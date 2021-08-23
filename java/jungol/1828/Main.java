 /**
 * @author suho kim
 * @no 1828
 * @title 냉장고
 * @url http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1101&sca=3050
 * @date 2021.08.17
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Pair
{
  int low;
  int high;
  public Pair(int low, int high)
  {
    this.low = low;
    this.high = high;
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    ArrayList<Pair> arr = new ArrayList<Pair>();
    for(int i=0; i<N; ++i)
    {
      st = new StringTokenizer(br.readLine());
      arr.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    Collections.sort(arr, new Comparator<Pair>(){
      @Override
      public int compare(Pair pair1, Pair pair2)
      {
        return pair1.high - pair2.high;
      }
    });

    int highTemp = arr.get(0).high;
    int count = 1;
    for(int i=1; i<arr.size(); ++i)
    {
      if(arr.get(i).low > highTemp)
      {
        ++count;
        highTemp = arr.get(i).high;
      }
    }

    System.out.println(count);
  }
}