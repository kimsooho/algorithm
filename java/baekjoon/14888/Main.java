
/**
 * @author suho kim
 * @no 14888
 * @title 연산자 끼워넣기
 * @url https://www.acmicpc.net/problem/14888
 * @date 2021.11.15
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int[] nums;
  static int[] opers;

  static int[] operCount;
  static char[] operOutput;
  static char[] operChar = { '+', '-', '*', '/' };

  static int maxVal;
  static int minVal;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());

    nums = new int[N];
    operOutput = new char[N - 1];
    opers = new int[4];
    operCount = new int[4];
    maxVal = -Integer.MAX_VALUE;
    minVal = Integer.MAX_VALUE;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; ++i) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; ++i) {
      opers[i] = Integer.parseInt(st.nextToken());
    }

    run(0);
    System.out.println(maxVal);
    System.out.println(minVal);
  }

  private static void run(int depth) {
    if (depth == N - 1) {
      cal();
      return;
    }

    for (int i = 0; i < 4; ++i) {
      if (operCount[i] < opers[i]) {
        ++operCount[i];
        operOutput[depth] = operChar[i];
        run(depth + 1);
        --operCount[i];
      }
    }
  }

  private static void cal() {
    int retVal = nums[0];

    for (int i = 0; i < N - 1; ++i) {
      char oper = operOutput[i];

      if (oper == '+') {
        retVal += nums[i + 1];
      } else if (oper == '-') {
        retVal -= nums[i + 1];
      } else if (oper == '*') {
        retVal *= nums[i + 1];
      } else {
        retVal /= nums[i + 1];
      }
    }

    maxVal = Math.max(maxVal, retVal);
    minVal = Math.min(minVal, retVal);
  }
}
