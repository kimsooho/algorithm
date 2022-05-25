/**
 * @author suho kim
 * @no 43238
 * @title 입국심사
 * @url https://programmers.co.kr/learn/courses/30/lessons/43238
 * @date 2022.05.25
 */
public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.solution(6, new int[] { 7, 10 }));
  }
}

class Solution {
  public long solution(int n, int[] times) {
    long answer = 0;
    long start = 0;
    long end = (long) times[times.length - 1] * (long) n;
    while (start <= end) {
      long mid = (start + end) / 2;

      long done = 0;
      for (int time : times) {
        done += mid / time;
      }

      if (done < n) {
        start = mid + 1;
      } else {
        end = mid - 1;
        answer = mid;
      }
    }
    return answer;
  }
}
