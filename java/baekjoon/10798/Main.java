
/**
 * @author suho kim
 * @no 10798
 * @title 세로읽기
 * @url https://www.acmicpc.net/problem/10798
 * @date 2021.09.06
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    ArrayList<StringBuilder> arr = new ArrayList<StringBuilder>();
    for (int i = 0; i < 5; ++i) {
      arr.add(new StringBuilder());
      arr.get(i).append(br.readLine());
    }

    StringBuilder sb = new StringBuilder();

    boolean isFinished = false;
    while (!isFinished) {
      isFinished = true;
      for (int i = 0; i < 5; ++i) {
        if (arr.get(i).length() != 0) {
          sb.append(arr.get(i).charAt(0));
          arr.get(i).delete(0, 1);
          isFinished = false;
        }
      }
    }

    System.out.println(sb);
  }
}
