/**
 * @author suho kim
 * @no 12899
 * @title 124 나라의 숫자
 * @url https://programmers.co.kr/learn/courses/30/lessons/12899
 * @date 2022.03.15
 */
public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.solution(1));
    System.out.println(s.solution(2));
    System.out.println(s.solution(3));
    System.out.println(s.solution(4));
  }
}

class Solution {
  int[] val = { 4, 1, 2 };

  public String solution(int n) {
    StringBuilder sb = new StringBuilder();
    while (n != 0) {
      int mod = n % 3;
      sb.insert(0, val[mod]);
      n /= 3;
      if (mod == 0)
        --n;
    }
    return sb.toString();
  }
}