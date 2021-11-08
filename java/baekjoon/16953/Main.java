
/**
 * @author suho kim
 * @no 16953
 * @title A → B
 * @url https://www.acmicpc.net/problem/16953
 * @date 2021.11.08
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Info {
  Long num;
  int step;

  public Info(Long num, int step) {
    this.num = num;
    this.step = step;
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    Long A = Long.parseLong(st.nextToken());
    Long B = Long.parseLong(st.nextToken());

    Queue<Info> q = new LinkedList<Info>();
    Info start = new Info(A, 1);
    q.offer(start);

    int result = -1;
    while (!q.isEmpty()) {
      Info info = q.poll();

      if (info.num.equals(B)) {
        result = info.step;
        break;
      }
      if (info.num * 2 <= B) {
        q.offer(new Info(info.num * 2, info.step + 1));
      }

      if (Long.parseLong(info.num + "1") <= B) {
        q.offer(new Info(Long.parseLong(info.num + "1"), info.step + 1));
      }
    }
    System.out.println(result);
  }
}
