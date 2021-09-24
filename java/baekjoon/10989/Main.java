
/**
 * @author suho kim
 * @no 10989
 * @title 수 정렬하기 3
 * @url https://www.acmicpc.net/problem/10989
 * @date 2021.09.24
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    for (int i = 0; i < N; ++i) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr);

    for (int i = 0; i < N; ++i) {
      sb.append(arr[i]).append("\n");
    }

    System.out.print(sb);
  }
}