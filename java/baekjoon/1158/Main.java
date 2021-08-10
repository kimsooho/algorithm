import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Queue<Integer> q = new LinkedList<Integer>();
    ArrayList<Integer> arr = new ArrayList<Integer>();
    for (int i = 1; i <= N; ++i) {
      q.offer(i);
    }

    int cnt = 0;

    while (!q.isEmpty()) {
      int num = q.poll();

      if (++cnt == K) {
        cnt = 0;
        arr.add(num);
      } else {
        q.offer(num);
      }
    }

    StringBuilder sb = new StringBuilder();

    sb.append("<");
    for (int n : arr) {
      sb.append(String.format("%d, ", n));
    }

    sb.delete(sb.length() - 2, sb.length()).append(">");

    System.out.println(sb);
  }
}
