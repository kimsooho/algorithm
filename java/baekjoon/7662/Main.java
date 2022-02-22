
/**
 * @author suho kim
 * @no 7662
 * @title 이중 우선순위 큐
 * @url https://www.acmicpc.net/problem/7662
 * @date 2022.02.22
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());

    while (T-- > 0) {
      TreeMap<Integer, Integer> tm = new TreeMap<>();

      int K = Integer.parseInt(br.readLine().trim());
      for (int i = 0; i < K; ++i) {
        st = new StringTokenizer(br.readLine());
        String cmd = st.nextToken();
        int val = Integer.parseInt(st.nextToken());

        if (cmd.equals("D")) {
          if (tm.isEmpty())
            continue;

          int key = 0;
          if (val == -1) {
            key = tm.firstKey();
          } else {
            key = tm.lastKey();
          }

          tm.replace(key, tm.get(key) - 1);
          if (tm.get(key) == 0) {
            tm.remove(key);
          }

        } else {
          tm.put(val, tm.getOrDefault(val, 0) + 1);
        }
      }

      if (tm.isEmpty())
        System.out.println("EMPTY");
      else
        System.out.println(String.format("%d %d", tm.lastKey(), tm.firstKey()));
    }
  }
}
