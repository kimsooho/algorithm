
/**
 * @author suho kim
 * @no 5554
 * @title 심부름 가는 길
 * @url https://www.acmicpc.net/problem/5554
 * @date 2021.11.26
 */
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int min = 0;

    for (int i = 0; i < 4; ++i) {
      min += sc.nextInt();
    }

    System.out.println(min / 60);
    System.out.println(min % 60);
  }
}
