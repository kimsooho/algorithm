
/**
 * @author suho kim
 * @no 5052
 * @title 전화번호 목록
 * @url https://www.acmicpc.net/problem/5052
 * @date 2021.09.01
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class LikeHash {
  HashMap<String, LikeHash> hashMap = null;
  boolean isLast = false;

  public LikeHash() {
    hashMap = new HashMap<String, LikeHash>();
  }

  public boolean insert(String phone, int idx) {
    if (idx == phone.length()) {
      this.isLast = true;
      if (this.hashMap.values().size() > 0) {
        return false;
      }
      return true;
    }

    String key = String.valueOf(phone.charAt(idx));
    this.isLast = false;
    if (hashMap.containsKey(key)) {
      if (hashMap.get(key).isLast) {
        return false;
      }
    }
    if (!hashMap.containsKey(key)) {
      hashMap.put(key, new LikeHash());
    }
    return hashMap.get(key).insert(phone, idx + 1);
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    while (t-- != 0) {
      int N = Integer.parseInt(br.readLine());
      boolean isSuccess = true;
      LikeHash hash = new LikeHash();
      for (int i = 0; i < N; ++i) {
        String phone = br.readLine();
        if (!hash.insert(phone, 0)) {
          isSuccess = false;
        }
      }

      System.out.println(!isSuccess ? "NO" : "YES");
    }
  }
}