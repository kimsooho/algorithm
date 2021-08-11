import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    HashMap<String, String> dic = new HashMap<String, String>();
    dic.put(")", "(");
    dic.put("]", "[");
    dic.put("(", "2");
    dic.put("[", "3");

    Stack<String> st = new Stack<String>();
    String brackets = br.readLine().trim();

    for (int i = 0; i < brackets.length(); ++i) {
      String bracket = Character.toString(brackets.charAt(i));

      if (bracket.equals("(") || bracket.equals("[")) {
        st.push(bracket);
      } else {
        if (st.isEmpty()) {
          System.out.println(0);
          return;
        }

        String top = st.pop();

        if (top.equals("(")) {
          if (bracket.equals("]")) {
            System.out.println(0);
            return;
          }
          st.push("2");
        } else if (top.equals("[")) {
          if (bracket.equals(")")) {
            System.out.println(0);
            return;
          }
          st.push("3");
        } else {
          int num = Integer.parseInt(top);
          Boolean isClosed = false;
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
      if (dic.containsKey(s)) {
        System.out.println(0);
        return;
      }
      result += Integer.parseInt(s);

    }

    System.out.println(result);
  }
}
