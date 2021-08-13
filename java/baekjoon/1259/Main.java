import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input;

    while (!(input = br.readLine()).equals("0")) {
      String ans = "yes";
      for (int i = 0; i <= (input.length() - 1) / 2; ++i) {
        if (!Character.valueOf(input.charAt(i)).equals(Character.valueOf(input.charAt(input.length() - 1 - i)))) {
          ans = "no";
          break;
        }
      }

      System.out.println(ans);
    }
  }
}