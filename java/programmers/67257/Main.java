
/**
 * @author suho kim
 * @no 67257
 * @title 수식 최대화
 * @url https://programmers.co.kr/learn/courses/30/lessons/67257
 * @date 2022.03.22
 */
import java.util.Deque;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.solution("100-200*300-500+20"));
    System.out.println(s.solution("50*6-3*2"));
  }
}

class Solution {
  String[] expressions = { "*", "+", "-" };
  String[] priorityExp = new String[3];
  boolean[] visited = new boolean[3];

  String expression;

  long answer;

  public long solution(String expression) {
    answer = 0;
    this.expression = expression;
    comb(0);
    return answer;
  }

  private void comb(int depth) {
    if (depth == 3) {
      answer = Math.max(answer, cal());
      return;
    }

    for (int i = 0; i < 3; ++i) {
      if (!visited[i]) {
        visited[i] = true;
        priorityExp[depth] = expressions[i];
        comb(depth + 1);
        visited[i] = false;
      }
    }
  }

  private long cal() {
    Deque<String> originDQ = new LinkedList<String>();
    String number = "";
    for (int i = 0; i < expression.length(); ++i) {
      char element = expression.charAt(i);
      if (isExpression(String.valueOf(element))) {
        originDQ.offerLast(number);
        originDQ.offerLast(String.valueOf(element));
        number = "";
      } else {
        number += element;
      }
    }
    originDQ.offerLast(number);

    Deque<String> tmpDQ = new LinkedList<String>();
    for (String exp : priorityExp) {
      while (!originDQ.isEmpty()) {
        String cmd = originDQ.pollFirst();
        if (isExpression(cmd)) {
          if (exp.equals(cmd)) {
            String prevNumber = tmpDQ.pollLast();
            tmpDQ.offerLast(String.valueOf(calculation(prevNumber, originDQ.pollFirst(), cmd)));
            continue;
          }
        }
        tmpDQ.offerLast(cmd);
      }
      originDQ = new LinkedList<String>(tmpDQ);
      tmpDQ.clear();
    }

    return Math.abs(Long.parseLong(originDQ.peek()));
  }

  private boolean isExpression(String expression) {
    if (expression.equals("*") || expression.equals("+") || expression.equals("-"))
      return true;
    return false;
  }

  private long calculation(String number1, String number2, String exp) {
    if (exp.equals("*")) {
      return Long.parseLong(number1) * Long.parseLong(number2);
    } else if (exp.equals("+")) {
      return Long.parseLong(number1) + Long.parseLong(number2);
    } else {
      return Long.parseLong(number1) - Long.parseLong(number2);
    }
  }
}