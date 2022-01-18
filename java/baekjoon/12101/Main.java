
/**
 * @author suho kim
 * @no 12101
 * @title 1, 2, 3 더하기 2
 * @url https://www.acmicpc.net/problem/12101
 * @date 2022.01.18
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  static int[] nums;
  static Stack<Integer> stack;

  static int N;
  static int K;

  static String result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    nums = new int[] { 1, 2, 3 };
    stack = new Stack<Integer>();

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    result = "-1";
    run(0);

    System.out.println(result);
  }

  private static void run(int sum) {
    if (K == 0 || sum > N)
      return;

    if (sum == N) {
      if (--K == 0) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
          sb.append(stack.pop());
          sb.append("+");
        }
        sb.delete(sb.length() - 1, sb.length());
        result = sb.reverse().toString();
      }
      return;
    }

    for (int i = 0; i < 3; ++i) {
      stack.push(nums[i]);
      run(sum + nums[i]);
      if (!stack.isEmpty())
        stack.pop();
    }
  }
}
