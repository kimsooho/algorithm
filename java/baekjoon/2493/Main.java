import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {  
  public static void main(String[] args) throws IOException{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Stack<Integer> heightSt = new Stack<Integer>();
    Stack<Integer> indexSt = new Stack<Integer>();
    
    int count = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < count; ++i) {
      int h = Integer.parseInt(st.nextToken());
      while (!heightSt.isEmpty()) {
        if (h < heightSt.peek()) {
          sb.append(indexSt.peek() + " ");
          break;
        }

        heightSt.pop();
        indexSt.pop();
      }
      if(heightSt.isEmpty())
      {
        sb.append(0 + " ");
      }

      heightSt.push(h);
      indexSt.push(i+1);
    }

    System.out.println(sb);
  }   
}
