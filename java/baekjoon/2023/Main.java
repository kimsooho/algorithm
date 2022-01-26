
/**
 * @author suho kim
 * @no 2023
 * @title 신기한 소수
 * @url https://www.acmicpc.net/problem/2023
 * @date 2022.01.26
 */
import java.util.Scanner;

public class Main {
  static int[] nums;
  static int N;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();

    nums = new int[] { 1, 2, 3, 5, 7, 9 };

    run(0, 0);
  }

  private static void run(int depth, int number) {
    if (depth == N) {
      System.out.println(number);
      return;
    }

    for (int n : nums) {
      int val = number * 10 + n;
      if (isPrime(val)) {
        run(depth + 1, val);
      }
    }
  }

  private static boolean isPrime(int number) {
    if (number == 1)
      return false;

    int sqrt = (int) Math.sqrt(number);

    for (int i = 2; i <= sqrt; ++i) {
      if (number % i == 0)
        return false;
    }

    return true;
  }
}
