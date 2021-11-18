
/**
 * @author suho kim
 * @no 11365
 * @title !밀비 급일
 * @url https://www.acmicpc.net/problem/11365
 * @date 2021.11.18
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb;

    while (true) {
      sb = new StringBuilder();
      sb.append(br.readLine());
      if (sb.toString().equals("END"))
        break;

      System.out.println(sb.reverse());
    }
  }
}
