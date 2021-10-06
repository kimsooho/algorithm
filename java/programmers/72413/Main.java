/**
 * @author suho kim
 * @no 72413
 * @title 합승 택시 요금
 * @url https://programmers.co.kr/learn/courses/30/lessons/72413
 * @date 2021.10.05
 */
public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    int cost = s.solution(6, 4, 6, 2, new int[][] { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 },
        { 4, 6, 50 }, { 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } });

    System.out.println(cost);

    cost = s.solution(7, 3, 4, 1, new int[][] { { 5, 7, 9 }, { 4, 6, 4 }, { 3, 6, 1 }, { 3, 2, 3 }, { 2, 1, 6 } });
    System.out.println(cost);
  }
}

class Solution {
  public int solution(int n, int s, int a, int b, int[][] fares) {
    int answer = Integer.MAX_VALUE;

    int[][] map = new int[n + 1][n + 1];
    for (int i = 1; i < n + 1; ++i) {
      for (int j = 1; j < n + 1; ++j) {
        map[i][j] = Integer.MAX_VALUE / 2;
      }
    }

    for (int i = 0; i < fares.length; ++i) {
      int from = fares[i][0];
      int to = fares[i][1];
      int cost = fares[i][2];

      map[from][to] = cost;
      map[to][from] = cost;
    }

    for (int via = 1; via < n + 1; ++via) {
      for (int from = 1; from < n + 1; ++from) {
        for (int to = 1; to < n + 1; ++to) {
          if (from == to) {
            map[from][to] = 0;
          } else
            map[from][to] = Math.min(map[from][to], map[from][via] + map[via][to]);
        }
      }
    }

    for (int i = 1; i <= n; ++i) {
      int cost = map[s][i] + map[i][a] + map[i][b];
      if (cost < 0)
        continue;
      answer = Math.min(answer, cost);
    }

    return answer;
  }
}