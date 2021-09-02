
/**
 * @author suho kim
 * @dest 2018 KAKAO BLIND RECRUITMENT
 * @title 비밀지도 
 * @url https://programmers.co.kr/learn/courses/30/lessons/17681
 * @date 2021.09.02
 */
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    Solution s = new Solution();
    s.solution(5, new int[] { 9, 20, 28, 18, 11 }, new int[] { 30, 1, 21, 17, 28 });
  }
}

class Solution {
  public String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];
    for (int i = 0; i < n; ++i) {
      int oper = arr1[i] | arr2[i];
      StringBuilder retValue = new StringBuilder();
      for (int j = 0; j < n; ++j) {
        retValue.append((oper & 1) == 1 ? "#" : " ");
        oper /= 2;
      }
      answer[i] = retValue.reverse().toString();
    }
    return answer;
  }
}
