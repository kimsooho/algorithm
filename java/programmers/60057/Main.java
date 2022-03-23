/**
 * @author suho kim
 * @no 60057
 * @title 문자열 압축
 * @url https://programmers.co.kr/learn/courses/30/lessons/60057
 */
public class Main {

}

class Solution {
  public int solution(String s) {
    int answer = Integer.MAX_VALUE;
    StringBuilder sb = new StringBuilder();
    sb.append(s);
    int harf = (sb.length() + 1) / 2;

    for (int i = 1; i <= harf; ++i) {

      String prev = "";
      int L = sb.length();

      int count = 0;
      for (int j = 0; (j + 1) * i <= sb.length(); ++j) {
        String sub = sb.substring(j * i, (j + 1) * i);
        if (!prev.equals(sub)) {
          prev = sub;
          if (count > 1) {
            L += Integer.toString(count).length();
          }
          count = 1;
        } else {
          L -= i;
          ++count;
        }
      }
      if (count > 1) {
        L += Integer.toString(count).length();
      }

      answer = Math.min(answer, L);
    }
    return answer;
  }
}