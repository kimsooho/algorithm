import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    System.out.println(cal(N));
  }

  private static int cal(int n) {
    int b = 0;
    while (true) {
      if ((n - b * 3) % 5 == 0)
        return b + (n - b * 3) / 5;
      if ((n - b * 3) < 3)
        return -1;
      b++;
    }
  }
}
