/**
 * @author suho kim
 * @no 84512
 * @title 모음 사전
 * @url https://programmers.co.kr/learn/courses/30/lessons/84512
 * @date 2022.05.18
 */
public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.solution("AAAAE"));
    System.out.println(s.solution("AAAE"));
    System.out.println(s.solution("I"));
    System.out.println(s.solution("EIO"));
  }
}

class Solution {
  boolean isFound = false;
  String targetWord;
  String[] alpha = new String[] { "A", "E", "I", "O", "U" };
  int answer;

  public int solution(String word) {
    this.targetWord = word;
    this.isFound = false;
    this.answer = 0;

    findWord("");
    return answer;
  }

  private void findWord(String word) {
    if (isFound || word.length() > 5) {
      return;
    }

    if (targetWord.equals(word)) {
      isFound = true;
      return;
    }

    ++answer;

    for (int i = 0; i < 5; ++i) {
      findWord(word + alpha[i]);
    }
  }
}