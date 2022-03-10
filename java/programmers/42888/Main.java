
/**
 * @author suho kim
 * @no 42888
 * @title 오픈채팅방
 * @url https://programmers.co.kr/learn/courses/30/lessons/42888
 * @date 2022.03.11
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out
        .println(Arrays.toString(s.solution(new String[] { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234",
            "Enter uid1234 Prodo", "Change uid4567 Ryan" })));
  }
}

class Solution {
  public String[] solution(String[] record) {
    String[] answer = {};
    List<String> answers = new ArrayList<String>();
    HashMap<String, String> hm = new HashMap<String, String>();
    for (String element : record) {
      String[] split = element.split(" ");
      if (split.length != 2) {
        hm.put(split[1], split[2]);
      }
    }

    for (String element : record) {
      String[] split = element.split(" ");
      String cmd = split[0];
      if (cmd.equals("Enter")) {
        answers.add(String.format("%s님이 들어왔습니다.", hm.get(split[1])));
      } else if (cmd.equals("Leave")) {
        answers.add(String.format("%s님이 나갔습니다.", hm.get(split[1])));
      }
    }
    answer = answers.toArray(new String[answer.length]);
    return answer;
  }
}
