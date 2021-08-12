import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    HashMap<String, String> dic = new HashMap<String, String>();

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      dic.put(st.nextToken(), st.nextToken());
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < M; ++i) {
      sb.append(dic.get(br.readLine().trim())).append("\n");
    }

    sb.delete(sb.length() - 1, sb.length());

    System.out.println(sb);
  }
}
