import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int tmpA = a;
    int tmpB = b;
    while (tmpB != 0) {
      int mod = tmpA % tmpB;

      tmpA = tmpB;
      tmpB = mod;
    }

    System.out.println(tmpA);
    System.out.println(a * b / tmpA);
  }
}
