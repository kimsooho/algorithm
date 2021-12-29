
/**
 * @author suho kim
 * @no 15658
 * @title 연산자 끼워넣기 (2)
 * @url https://www.acmicpc.net/problem/15658
 * @date 2021.12.29
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int[] nums;
  static int[] operCount;
  static int[] selectedOperCount;
  static int[] opers;

  static int maxVal;
  static int minVal;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    maxVal = Integer.MIN_VALUE;
    minVal = Integer.MAX_VALUE;

    N = Integer.parseInt(st.nextToken());
    nums = new int[N];
    operCount = new int[4];
    selectedOperCount = new int[4];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; ++i) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; ++i) {
      operCount[i] = Integer.parseInt(st.nextToken());
    }

    opers = new int[N - 1];

    per(0);
    System.out.println(maxVal);
    System.out.println(minVal);
  }

  private static void per(int depth) {
    if (depth == N - 1) {
      int value = cal();

      maxVal = Integer.max(maxVal, value);
      minVal = Integer.min(minVal, value);
      return;
    }

    for (int i = 0; i < 4; ++i) {
      if (selectedOperCount[i] < operCount[i]) {
        ++selectedOperCount[i];
        opers[depth] = i;
        per(depth + 1);
        --selectedOperCount[i];
      }
    }
  }

  private static int cal() {
    int retValue = nums[0];

    for (int i = 1; i < N; ++i) {
      int oper = opers[i - 1];
      int num = nums[i];
      if (oper == 0) {
        retValue += num;
      } else if (oper == 1) {
        retValue -= num;
      } else if (oper == 2) {
        retValue *= num;
      } else {
        retValue /= num;
      }
    }

    return retValue;
  }
}
