/**
 * @author suho kim
 * @no 42883
 * @title 큰 수 만들기
 * @url https://programmers.co.kr/learn/courses/30/lessons/42883
 * @date 2022.03.30
 */
public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    // System.out.println(s.solution("1924", 2));
    System.out.println(s.solution("1231234", 3));
    System.out.println(s.solution("4177252841", 4));
    // System.out.println(s.solution("4177252841", 4));
  }
}

class Solution {
  public String solution(String number, int k) {
    StringBuilder sb = new StringBuilder();
    String answer = "";

    int length = number.length() - k;
    int start = 0;
    int end = number.length() - length;

    while (true) {
      if (sb.length() >= length)
        break;

      int cur = start;
      int maxValue = Integer.MIN_VALUE;
      int maxIdx = cur;
      for (int i = cur; i <= end && i < number.length(); ++i) {
        if (maxValue < number.charAt(i) - '0') {
          maxValue = number.charAt(i) - '0';
          maxIdx = i;
        }
      }

      start = maxIdx + 1;
      sb.append(maxValue);
      ++end;
    }
    answer = sb.toString();
    return answer;
  }
}