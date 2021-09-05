
/** 
 * @author suho kim
 * @no 11053
 * @title 가장 긴 증가하는 부분 수열
 * @url https://www.acmicpc.net/problem/11053
 * @date 2021.09.05
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static ArrayList<Integer> arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] nums = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    arr = new ArrayList<Integer>();
    for (int i = 0; i < N; ++i) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    arr.add(nums[0]);
    for (int i = 1; i < N; ++i) {
      if (arr.get(arr.size() - 1) < nums[i])
        arr.add(nums[i]);
      else
        binary(nums[i]);
    }

    System.out.println(arr.size());
  }

  private static void binary(int num) {
    int start = 0;
    int end = arr.size() - 1;

    int pos = 0;
    while (start <= end) {
      int mid = (start + end) / 2;

      if (arr.get(mid) >= num) {
        pos = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    arr.set(pos, num);
  }
}
