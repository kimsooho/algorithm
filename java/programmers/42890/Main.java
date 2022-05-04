
/**
 * @author suho kim
 * @no 42890
 * @title 후보키
 * @url https://programmers.co.kr/learn/courses/30/lessons/42890
 * @date 2022.05.04
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    // int ans = s.solution(new String[][] { { "100", "ryan", "music", "2" }, {
    // "200", "apeach", "math", "2" },
    // { "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, {
    // "500", "muzi", "music", "3" },
    // { "600", "apeach", "music", "2" } });

    int ans = s.solution(new String[][] { { "a", "aa" }, { "aa", "a" }, { "a", "a" } });

    System.out.println(ans);

  }
}

class Solution {
  ArrayList<HashSet<Integer>> candidateKey;
  int columnCount;
  String[][] realation;

  public int solution(String[][] relation) {
    this.realation = relation;
    candidateKey = new ArrayList<HashSet<Integer>>();
    columnCount = relation[0].length;

    for (int i = 0; i < columnCount; ++i) {
      makeSet(0, i + 1, 0, new HashSet<>());
    }

    return candidateKey.size();
  }

  public void makeSet(int idx, int limit, int count, HashSet<Integer> set) {
    if (count == limit) {
      if (!isUniqueKey(set)) {
        return;
      }
      for (HashSet<Integer> key : candidateKey) {
        if (set.containsAll(key)) {
          return;
        }
      }
      candidateKey.add(set);
      return;
    }

    for (int i = idx; i < columnCount; i++) {
      HashSet<Integer> nextSet = new HashSet<Integer>(set);
      nextSet.add(i);
      makeSet(i + 1, limit, count + 1, nextSet);
    }

  }

  public boolean isUniqueKey(HashSet<Integer> set) {
    Set<String> strSet = new HashSet<>();
    for (int i = 0; i < realation.length; i++) {
      String code = "";
      for (int index : set) {
        code += realation[i][index] + "*";
      }

      if (strSet.contains(code))
        return false;

      strSet.add(code);

    }
    return true;
  }
}