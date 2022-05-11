
/**
 * @author suho kim
 * @no 12911
 * @title 다음 큰 숫자
 * @url https://programmers.co.kr/learn/courses/30/lessons/12911
 * @date 2022.05.11
 */
public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.solution(78));
  }
}

class Solution {
  public int solution(int n) {
    int bitCount = Integer.bitCount(n);

    while (bitCount != Integer.bitCount(++n)) {
    }

    return n;
  }
}