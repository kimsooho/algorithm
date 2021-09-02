
/**
 * @author suho kim
 * @no 14725
 * @title 개미굴
 * @url https://www.acmicpc.net/problem/14725
 * @date 2021.09.02
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Hash {
  HashMap<String, Hash> hashMap;
  int depth;

  public Hash(int depth) {
    hashMap = new HashMap<String, Hash>();
    this.depth = depth;
  }

  public void print() {
    String[] keys = hashMap.keySet().toArray(new String[hashMap.size()]);
    Arrays.sort(keys);

    for (int i = 0; i < keys.length; ++i) {
      String hyphen = "";
      for (int hy = 0; hy < depth; ++hy) {
        hyphen += "--";
      }
      System.out.println(hyphen + keys[i]);
      hashMap.get(keys[i]).print();
    }
  }

  public void insert(String[] keys, int idx, int size) {
    if (size == idx)
      return;

    String key = keys[idx];
    if (hashMap.containsKey(key)) {
      hashMap.get(key).insert(keys, idx + 1, size);
    } else {
      hashMap.put(key, new Hash(depth + 1));
      hashMap.get(key).insert(keys, idx + 1, size);
    }
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    Hash hash = new Hash(0);
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      int strCount = Integer.parseInt(st.nextToken());
      String[] strings = new String[strCount];
      for (int j = 0; j < strCount; ++j) {
        strings[j] = st.nextToken();
      }

      hash.insert(strings, 0, strCount);
    }

    hash.print();
  }
}
