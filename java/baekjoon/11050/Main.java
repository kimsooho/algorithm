import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    N = recursive(N, K);
    K = recursive(K, K);

    System.out.println(N/K);
  }

  private static int recursive(int num, int count)
  {
    if(count == 0)
      return 1;

    return num * recursive(num - 1, count - 1);
  }
}
