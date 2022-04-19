
/**
 * @author suho kim
 * @no 42842
 * @title 카펫
 * @url https://programmers.co.kr/learn/courses/30/lessons/42842
 * @date 2022.04.20
 */
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(Arrays.toString(s.solution(10, 2)));
    System.out.println(Arrays.toString(s.solution(8, 1)));
    System.out.println(Arrays.toString(s.solution(24, 24)));
  }
}

class Solution {
  public int[] solution(int brown, int yellow) {
    int[] answer = {};
    int sqrt = (int) Math.sqrt(brown + yellow);
    int y = 3;
    int x = (brown + yellow) / y;
    while ((x - 2) * (y - 2) != yellow) {
      x = (brown + yellow) / ++y;
    }
    answer = new int[] { x, y };
    return answer;
  }
}