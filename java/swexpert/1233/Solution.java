import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int t = 1; t <= 10; ++t) {
      int N = Integer.parseInt(br.readLine());
      int result = 1;
      for (int i = 1; i <= N; ++i) {
        String[] inputs = br.readLine().split(" ");

        if (inputs.length == 4) {
          if ((!inputs[1].equals("+") && !inputs[1].equals("-") && !inputs[1].equals("*") && !inputs[1].equals("/"))
              || inputs[2].equals("+") || inputs[2].equals("-") || inputs[2].equals("*") || inputs[2].equals("/")
              || inputs[3].equals("+") || inputs[3].equals("-") || inputs[3].equals("*") || inputs[3].equals("/")) {
            result = 0;
          }
        }
      }
      System.out.println(String.format("#%d %d", t, result));
    }
  }
}
