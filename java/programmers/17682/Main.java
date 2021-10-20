
/**
 * @author suho kim
 * @no 17682
 * @title [1차] 다트 게임
 * @url https://programmers.co.kr/learn/courses/30/lessons/17682
 * @date 2021.10.20
 */
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.solution("1S2D*3T"));
  }
}

class Solution {
  public int solution(String dartResult) {
    Stack<Integer> st = new Stack<Integer>();
    int answer = 0;
    String num = "";
    for (int i = 0; i < dartResult.length(); ++i) {
      char c = dartResult.charAt(i);
      if ('0' <= c && c <= '9') {
        num += c;
      } else {
        if (c == 'S') {
          st.push(Integer.parseInt(num));
        } else if (c == 'D') {
          st.push((int) Math.pow(Integer.parseInt(num), 2));
        } else if (c == 'T') {
          st.push((int) Math.pow(Integer.parseInt(num), 3));
        } else if (c == '*') {
          int n = st.pop() * 2;
          if (!st.empty()) {
            st.push(st.pop() * 2);
          }
          st.push(n);
        } else if (c == '#') {
          st.push(st.pop() * -1);
        }
        num = "";
      }
    }

    while (!st.empty()) {
      answer += st.pop();
    }
    return answer;
  }
}