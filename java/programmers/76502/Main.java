
/**
 * @author suho kim
 * @no 76502
 * @title 괄호 회전하기
 * @url https://programmers.co.kr/learn/courses/30/lessons/76502
 * @date 2022.04.13
 */
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.solution("[](){}"));
    System.out.println(s.solution("}]()[{"));
    System.out.println(s.solution("[)(]"));
    System.out.println(s.solution("}}}"));
  }
}

class Solution {
  public int solution(String s) {
    int answer = 0;
    StringBuilder sb = new StringBuilder(s);

    for (int i = 0; i < s.length(); ++i) {
      if (isVaildBracket(sb.toString())) {
        ++answer;
      }

      String subStr = sb.substring(0, 1);
      sb.delete(0, 1);
      sb.append(subStr);
    }

    return answer;
  }

  private boolean isVaildBracket(String s) {
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < s.length(); ++i) {
      char bracket = s.charAt(i);

      if (bracket == '{' || bracket == '[' || bracket == '(') {
        stack.push(bracket);
      } else if (!stack.isEmpty() && (stack.lastElement() == '{' && bracket == '}'
          || stack.lastElement() == '[' && bracket == ']' || stack.lastElement() == '(' && bracket == ')')) {
        stack.pop();
      } else {
        return false;
      }
    }

    if (stack.isEmpty())
      return true;

    return false;
  }
}