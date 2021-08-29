
/**
 * @author suho kim
 * @no 2999
 * @title 비밀 이메일
 * @url https://www.acmicpc.net/problem/2999
 * @date 2021.08.29
 */
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String input = sc.nextLine();
    int R = 0;
    int lenth = input.length();
    int sqrt = (int) Math.sqrt(lenth);
    for (int i = 1; i <= sqrt; ++i) {
      if (lenth % i == 0) {
        R = i;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < R; ++i) {
      for (int j = i; j < lenth; j += R) {
        sb.append(input.charAt(j));
      }
    }
    System.out.println(sb);
  }
}
