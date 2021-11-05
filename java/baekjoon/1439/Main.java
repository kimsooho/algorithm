
/**
 * @author suho kim
 * @no 1439
 * @title 뒤집기
 * @url https://www.acmicpc.net/problem/1439
 * @date 2021.11.05
 */
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();

    int[] count = new int[2];

    int prevNum = -1;
    for (int i = 0; i < line.length(); ++i) {
      if (prevNum != line.charAt(i) - '0') {
        prevNum = line.charAt(i) - '0';
        ++count[prevNum];
      }
    }

    System.out.println(Math.min(count[0], count[1]));
  }
}
