
/**
 * @author suho kim
 * @no 9251
 * @title LCS
 * @url https://www.acmicpc.net/problem/9251
 * @date 2022.02.08
 */
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str1 = sc.nextLine();
    String str2 = sc.nextLine();

    int[][] memo = new int[str1.length() + 1][str2.length() + 1];

    for (int i = 1; i <= str1.length(); ++i) {
      for (int j = 1; j <= str2.length(); ++j) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          memo[i][j] = memo[i - 1][j - 1] + 1;
        } else {
          memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
        }
      }
    }

    System.out.println(memo[str1.length()][str2.length()]);
  }
}
