/**
 * @author suho kim
 * @no 42626
 * @title 더 맵게
 * @url https://programmers.co.kr/learn/courses/30/lessons/42626 
 * @date 2022.02.24
 */
import java.util.PriorityQueue;

public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7));
  }
}

class Solution {
  public int solution(int[] scoville, int K) {
    int answer = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    for (int s : scoville) {
      pq.offer(s);
    }

    while (pq.peek() < K && pq.size() > 1) {
      ++answer;
      int n1st = pq.poll();
      int n2nd = pq.poll() * 2;

      pq.offer(n1st + n2nd);
    }

    return pq.peek() < K ? -1 : answer;
  }
}
