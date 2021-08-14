import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    

    while (true) {
      ArrayList<Integer> arr = new ArrayList<Integer>();
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr.add(Integer.parseInt(st.nextToken()));
      arr.add(Integer.parseInt(st.nextToken()));
      arr.add(Integer.parseInt(st.nextToken()));

      if (arr.get(0) + arr.get(1) + arr.get(2) == 0)
        break;

      Collections.sort(arr);
      if (Math.pow(arr.get(0), 2) + Math.pow(arr.get(1), 2) == Math.pow(arr.get(2), 2)) {
        System.out.println("right");
      } else {
        System.out.println("wrong");
      }
    }
  }
}
