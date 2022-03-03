
/**
 * @author suho kim
 * @no 1449
 * @title 수리공 항승
 * @url https://www.acmicpc.net/problem/1449 
 * @date 2022.03.04
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    List<Integer> list = new ArrayList<Integer>();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; ++i) {
      list.add(Integer.parseInt(st.nextToken()));
    }

    Collections.sort(list);

    int gap = 0;
    int result = 1;
    for (int i = 1; i < N; ++i) {
      gap += list.get(i) - list.get(i - 1);
      if (gap >= L) {
        gap = 0;
        ++result;
      }
    }

    System.out.println(result);

  }
}
