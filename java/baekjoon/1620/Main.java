import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    HashMap<String, String> dicStringInt = new HashMap<String, String>();
    HashMap<String, String> dicIntString = new HashMap<String, String>();
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    for (int i = 1; i <= N; ++i) {
      String pokemon = br.readLine();
      dicIntString.put(String.valueOf(i), pokemon);
      dicStringInt.put(pokemon, String.valueOf(i));
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; ++i) {
      String input = br.readLine();
      if (dicIntString.containsKey(input)) {
        sb.append(dicIntString.get(input)).append("\n");
      } else {
        sb.append(dicStringInt.get(input)).append("\n");
      }
    }

    sb.delete(sb.length() - 1, sb.length());

    System.out.println(sb);
  }
}
