
/**
 * @author suho kim
 * @no 5597
 * @title 과제 안 내신 분..?
 * @url https://www.acmicpc.net/problem/5597
 * @date 2021.08.27
 */
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean[] checked = new boolean[31];

    for (int i = 0; i < 28; ++i) {
      checked[Integer.parseInt(sc.nextLine())] = true;
    }

    for (int i = 1; i < 31; ++i) {
      if (!checked[i])
        System.out.println(i);
    }
  }
}
