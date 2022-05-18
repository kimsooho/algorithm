/**
 * @author suho kim
 * @no 49191
 * @title 순위
 * @url https://programmers.co.kr/learn/courses/30/lessons/49191
 * @date 2022.05.18
 */
public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.solution(5, new int[][] { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } }));
  }
}

class Solution {
  public int solution(int n, int[][] results) {
    int answer = 0;
    int[][] graph = new int[n + 1][n + 1];
    for (int i = 1; i <= n; ++i) {
      for (int j = 1; j <= n; ++j) {
        graph[i][j] = Integer.MAX_VALUE / 2;
      }
    }

    for (int[] result : results) {
      int winner = result[0];
      int loser = result[1];

      graph[winner][loser] = 1;
    }

    for (int via = 1; via <= n; ++via) {
      for (int from = 1; from <= n; ++from) {
        for (int to = 1; to <= n; ++to) {
          if (from != to) {
            graph[from][to] = Math.min(graph[from][to], graph[from][via] + graph[via][to]);
          }
        }
      }
    }

    for (int i = 1; i <= n; ++i) {
      int knownCount = 0;
      for (int j = 1; j <= n; ++j) {
        if (i == j) {
          continue;
        }

        if (graph[i][j] != Integer.MAX_VALUE / 2 || graph[j][i] != Integer.MAX_VALUE / 2) {
          ++knownCount;
        }
      }

      if (knownCount == n - 1) {
        ++answer;
      }
    }

    return answer;
  }
}