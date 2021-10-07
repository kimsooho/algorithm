
/**
 * @author suho kim
 * @no 1676
 * @title 팩토리얼 0의 개수
 * @url https://www.acmicpc.net/problem/1676
 * @date 2021.10.07
 */
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    int N = (new Scanner(System.in)).nextInt();

    int result = 0;

    while (N >= 5) {
      result += N /= 5;
    }

    System.out.println(result);
  }
}
