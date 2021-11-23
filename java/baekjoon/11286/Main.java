
/**
 * @author suho kim
 * @no 11286
 * @title 절댓값 힙
 * @url https://www.acmicpc.net/problem/11286
 * @date 2021.11.23
 */
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        if (Math.abs(o1) == Math.abs(o2)) {
          return o1 - o2;
        }
        return Math.abs(o1) - Math.abs(o2);
      }
    });

    for (int i = 0; i < N; ++i) {
      int input = sc.nextInt();

      if (input == 0) {
        if (pq.isEmpty()) {
          System.out.println(0);
        } else {
          System.out.println(pq.poll());
        }
      } else {
        pq.offer(input);
      }
    }
  }
}
