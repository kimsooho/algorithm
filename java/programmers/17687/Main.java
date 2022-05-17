/**
 * @author suho kim
 * @no 17687
 * @title n진수 게임
 * @url https://programmers.co.kr/learn/courses/30/lessons/17687
 * @date 2022.05.18
 */
public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.solution(2, 4, 2, 1));
    System.out.println(s.solution(16, 16, 2, 1));
    System.out.println(s.solution(16, 16, 2, 2));
  }
}

class Solution {
  public String solution(int n, int t, int m, int p) {
    String answer = "";
    StringBuilder sb = new StringBuilder();
    for (int i = 0; sb.length() < t * m + (p - 1); ++i) {
      sb.append(Integer.toString(i, n));
    }

    for (int i = 0; i < t; ++i) {
      int idx = (i * m) + (p - 1);
      answer += sb.substring(idx, idx + 1);
    }
    return answer.toUpperCase();

  }
}