
/**
 * @author suho kim
 * @no 42748
 * @title K번째수
 * @url https://programmers.co.kr/learn/courses/30/lessons/42748
 * @date 2022.05.18
 */
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(Arrays.toString(
        s.solution(new int[] { 1, 5, 2, 6, 3, 7, 4 }, new int[][] { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } })));
  }
}

class Solution {
  public int[] solution(int[] array, int[][] commands) {
    int length = commands.length;
    int[] answer = new int[length];
    for (int i = 0; i < length; ++i) {
      int from = commands[i][0] - 1;
      int to = commands[i][1];
      int idx = commands[i][2] - 1;
      int[] arraySlice = Arrays.copyOfRange(array, from, to);
      Arrays.sort(arraySlice);

      answer[i] = arraySlice[idx];
    }

    return answer;
  }
}