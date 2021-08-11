import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    HashMap<String, String> dic = new HashMap<String, String>(); // 괄호 조건에 대응하기 위해 Dictionary 처리
    dic.put(")", "(");
    dic.put("]", "[");
    dic.put("(", "2");
    dic.put("[", "3");

    Stack<String> st = new Stack<String>();
    String brackets = br.readLine().trim();

    for (int i = 0; i < brackets.length(); ++i) {
      String bracket = Character.toString(brackets.charAt(i));

      if (bracket.equals("(") || bracket.equals("[")) { // 열린 괄호 push
        st.push(bracket);
      } else {
        if (st.isEmpty()) { // 열린 괄호 이외의 커맨드시 Empty라면 예외
          System.out.println(0);
          return;
        }

        String top = st.pop();

        if (top.equals("(") || top.equals("[")) { // top이 열린 괄호라면 Input이 닫힌 괄호여야 함
          if (!top.equals(dic.get(bracket))) { // 괄호의 짝이 안 맞으면 예외
            System.out.println(0);
            return;
          }
          st.push(dic.get(top)); // 열린 괄호에 맞는 value push    
        } else {
          int num = Integer.parseInt(top);
          Boolean isClosed = false; // ())))...에 대한 예외
          while (!st.empty()) {
            top = st.pop();

            if (dic.containsKey(top)) // 괄호
            {
              if (!dic.get(bracket).equals(top)) {
                System.out.println(0);
                return;
              }
              isClosed = true;
              num *= Integer.parseInt(dic.get(top));
              break;
            } else // 숫자
            {
              num += Integer.parseInt(top);
            }
          }
          if (!isClosed) {
            System.out.println(0);
            return;
          }
          st.push(Integer.toString(num));
        }
      }
    }

    int result = 0;
    for (String s : st) {
      if (dic.containsKey(s)) { // 스택안에 괄호 존재 여부 체크 후 예외
        System.out.println(0);
        return;
      }
      result += Integer.parseInt(s); // 괄호를 제외한 숫자 Sum

    }

    System.out.println(result);
  }
}
