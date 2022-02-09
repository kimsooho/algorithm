
/**
 * @author suho kim
 * @no 1904
 * @title 01타일
 * @url https://www.acmicpc.net/problem/1904
 * @date 2022.02.09
 */
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    int[] memo = new int[1000001];
    memo[0] = 0;
    memo[1] = 1;
    memo[2] = 2;

    for (int i = 3; i <= N; ++i) {
      memo[i] = (memo[i - 2] + memo[i - 1]) % 15746;
    }
    System.out.println(memo[N]);
  }
}
