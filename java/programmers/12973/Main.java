
/**
 * @author suho kim
 * @no 12973
 * @title 짝지어 제거하기
 * @url https://programmers.co.kr/learn/courses/30/lessons/12973
 * @date 2022.03.04
 */
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.solution("cdcd"));
  }
}

class Solution {
  public int solution(String s) {
    Stack<Character> st = new Stack<>();

    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      if (st.isEmpty() || st.peek() != c) {
        st.push(c);
      } else {
        st.pop();
      }
    }

    return st.isEmpty() ? 1 : 0;
  }
}
