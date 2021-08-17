import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack = new Stack<Integer>();

    int N = Integer.parseInt(st.nextToken());

    for(int n=0, s = 1; n<N; ++n)
    {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());

      while(true)
      {
        if(stack.isEmpty() || stack.peek() < num)
        {
          stack.push(s++);
          sb.append("+\n");
        }
        else if(stack.peek() == num)
        {
          stack.pop();
          sb.append("-\n");
          break;
        }
        else
        {
          System.out.println("NO");
          return;
        }
      }
    }

    System.out.println(sb.delete(sb.length() - 1, sb.length()));
  }
}
