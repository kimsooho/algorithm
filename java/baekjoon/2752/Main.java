
/**
 * @author suho kim
 * @no 2752
 * @title 세수정렬
 * @url https://www.acmicpc.net/problem/2752
 * @date 2021.10.31
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

    while (st.hasMoreTokens()) {
      pq.offer(Integer.parseInt(st.nextToken()));
    }

    while (!pq.isEmpty()) {
      System.out.print(pq.poll() + " ");
    }
  }
}
