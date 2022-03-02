
/**
 * @author suho kim
 * @no 19638
 * @title 센티와 마법의 뿅망치
 * @url https://www.acmicpc.net/problem/19638
 * @date 2022.03.02
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());
    int T = Integer.parseInt(st.nextToken());

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

    for (int i = 0; i < N; ++i) {
      pq.offer(Integer.parseInt(br.readLine().trim()));
    }

    int hitCount = 0;
    for (hitCount = 1; hitCount <= T; ++hitCount) {
      int target = pq.poll();
      if (target == 1 || target < H) {
        pq.offer(target);
        break;
      }

      pq.offer(target / 2);
    }

    if (pq.peek() < H) {
      System.out.println("YES\n" + (hitCount - 1));
    } else {
      System.out.println("NO\n" + pq.peek());
    }
  }
}
