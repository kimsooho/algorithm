
/**
 * @author suho kim
 * @no 23757
 * @title 아이들과 선물 상자
 * @url https://www.acmicpc.net/problem/23757
 * @date 2022.04.13
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
    int M = Integer.parseInt(st.nextToken());

    int[] children = new int[M];
    PriorityQueue<Integer> gifts = new PriorityQueue<Integer>(Collections.reverseOrder());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; ++i) {
      gifts.offer(Integer.parseInt(st.nextToken()));
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; ++i) {
      children[i] = Integer.parseInt(st.nextToken());
    }

    boolean success = true;
    for (int i = 0; i < M; ++i) {
      int gift = gifts.poll();
      if (gift < children[i]) {
        success = false;
        break;
      }

      gift -= children[i];
      gifts.offer(gift);
    }

    System.out.println(success ? 1 : 0);
  }
}
