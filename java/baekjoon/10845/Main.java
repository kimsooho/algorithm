import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Deque<Integer> dq = new LinkedList<Integer>();

    int cmdCount = Integer.parseInt(br.readLine());

    for(int i=0; i<cmdCount; ++i)
    {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String cmd = st.nextToken();

      if(cmd.equals("push"))
      {
        int num = Integer.parseInt(st.nextToken());
        dq.offer(num);
      }else if(cmd.equals("pop"))
      {
        System.out.println(dq.isEmpty() ? -1 : dq.pop());
      }
      else if(cmd.equals("size"))
      {
        System.out.println(dq.size());
      }
      else if(cmd.equals("empty"))
      {
        System.out.println(dq.isEmpty() ? 1 : 0);
      }
      else if(cmd.equals("front"))
      {
        System.out.println(dq.isEmpty() ? -1 : dq.peekFirst());
      }
      else if(cmd.equals("back"))
      {
        System.out.println(dq.isEmpty() ? -1 : dq.peekLast());
      }
    }
  }
}
