
/**
 * @author suho kim
 * @no 16637
 * @title 괄호 추가하기
 * @url https://www.acmicpc.net/problem/16637
 * @date 2021.12.15
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int ans = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int length = Integer.parseInt(br.readLine());
    String expression = br.readLine();
    rec(expression, 0, false);
    System.out.println(ans);
  }

  private static void rec(String expression, int idx, boolean hasOpenBracket) {
    if (expression.length() <= idx) {
      if (!hasOpenBracket) {
        ans = Math.max(ans, cal(expression));
      }
      return;
    }

    StringBuilder sb = new StringBuilder();
    sb.append(expression);
    for (int i = idx; i < expression.length(); ++i) {
      char c = expression.charAt(i);

      if (c >= '0' && c <= '9') {
        if (hasOpenBracket) {
          sb.insert(i + 1, ')');
          rec(sb.toString(), i + 2, false);
          return;
        } else {
          rec(sb.toString(), i + 2, false);
          sb.insert(i, '(');
          rec(sb.toString(), i + 3, true);
          sb.delete(i, i + 1);
        }
      }
    }
  }

  private static int cal(String expression) {
    int retValue = 0;
    for (int i = 0; i < expression.length(); ++i) {
      char c = expression.charAt(i);
      if (c >= '0' && c <= '9') {
        retValue = c - '0';
      } else if (c == '(') {
        retValue = expression.charAt(++i) - '0';
        while (true) {
          char exp = expression.charAt(++i);
          if (exp == ')')
            break;
          c = expression.charAt(++i);
          switch (exp) {
            case '+':
              retValue += c - '0';
              break;
            case '-':
              retValue -= c - '0';
              break;
            case '*':
              retValue *= c - '0';
              break;
          }
        }
      } else {
        char exp = c;
        c = expression.charAt(++i);
        int num = 0;
        if (c == '(') {
          num = expression.charAt(++i) - '0';
          char _exp;
          while (true) {
            _exp = c;
            if (_exp == ')')
              break;
            c = expression.charAt(++i);
            switch (_exp) {
              case '+':
                num += c - '0';
                break;
              case '-':
                num -= c - '0';
                break;
              case '*':
                num *= c - '0';
                break;
            }
          }
        } else {
          num = c - '0';
        }
        switch (exp) {
          case '+':
            retValue += num;
            break;
          case '-':
            retValue -= num;
            break;
          case '*':
            retValue *= num;
            break;
        }
      }
    }
    return retValue;
  }
}
