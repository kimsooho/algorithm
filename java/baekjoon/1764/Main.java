
/**
 * @author suho kim
 * @no 1764
 * @title 듣보잡
 * @url https://www.acmicpc.net/problem/1764
 * @date 2021.09.17
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    HashSet<String> hash = new HashSet<String>();
    ArrayList<String> names = new ArrayList<String>();
    for (int i = 0; i < N + M; ++i) {
      String name = br.readLine();
      if (hash.contains(name)) {
        names.add(name);
      }
      hash.add(name);
    }
    Collections.sort(names);
    System.out.println(names.size());
    for (int i = 0; i < names.size(); ++i) {
      System.out.println(names.get(i));
    }
  }
}
