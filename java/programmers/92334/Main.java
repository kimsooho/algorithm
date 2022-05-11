
/**
 * @author suho kim
 * @no 92334
 * @title 신고 결과 받기
 * @url https://programmers.co.kr/learn/courses/30/lessons/92334
 * @date 2022.05.11
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(Arrays.toString(s.solution(new String[] { "con", "ryan" },
        new String[] { "ryan con", "ryan con", "ryan con", "ryan con" }, 3)));
  }
}

class Solution {
  public int[] solution(String[] id_list, String[] report, int k) {
    int[] answer = {};
    HashMap<String, HashSet<String>> reportList = new HashMap<String, HashSet<String>>();
    HashMap<String, Integer> reportCount = new HashMap<String, Integer>();

    for (int i = 0; i < id_list.length; ++i) {
      reportCount.put(id_list[i], 0);
      reportList.put(id_list[i], new HashSet<String>());
    }

    for (int i = 0; i < report.length; ++i) {
      String reporter = report[i].split(" ")[0];
      String target = report[i].split(" ")[1];

      if (!reportList.get(reporter).contains(target)) {
        reportList.get(reporter).add(target);
        reportCount.replace(target, reportCount.get(target) + 1);
      }
    }

    answer = new int[id_list.length];
    for (int i = 0; i < id_list.length; ++i) {
      HashSet<String> set = reportList.get(id_list[i]);

      int mailCount = 0;
      for (String target : set) {
        if (reportCount.get(target) >= k) {
          ++mailCount;
        }
      }
      answer[i] = mailCount;
    }

    return answer;
  }
}