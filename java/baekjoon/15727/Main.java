
/**
 * @author suho kim
 * @no 15727
 * @title 조별과제를 하려는데 조장이 사라졌다
 * @url https://www.acmicpc.net/problem/15727
 * @date 2021.12.13
 */
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int L = sc.nextInt();
    int count = L / 5;
    System.out.println(L % 5 == 0 ? count : count + 1);
  }
}
