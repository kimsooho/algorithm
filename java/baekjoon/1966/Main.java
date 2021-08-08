import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
  int index;
  int value;

  public Pair(int index, int value) {
    this.index = index;
    this.value = value;
  }
}

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    while (t-- != 0) {
      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
      Queue<Pair> q = new LinkedList<Pair>();

      int count = 0;

      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; ++i) {
        int num = Integer.parseInt(st.nextToken());
        pq.offer(num);
        q.offer(new Pair(i, num));
      }

      while (true) {
        int num = q.peek().value;
        int idx = q.peek().index;
        Pair pair = q.poll();

        if (pq.peek() == num) {
          ++count;
          if (idx == M) {
            System.out.println(count);
            break;
          }
          pq.poll();
        }
        else
        {
          q.offer(pair);
        }
      }
    }
  }
}