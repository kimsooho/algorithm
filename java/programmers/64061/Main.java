
/**
 * @author suho kim
 * @no 64061
 * @title 크레인 인형뽑기 게임
 * @url https://programmers.co.kr/learn/courses/30/lessons/64061
 * @date 2021.09.28
 */

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] board = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
        { 3, 5, 1, 3, 1 } };
    int[] moves = new int[] { 1, 5, 3, 5, 1, 2, 1, 4 };
    System.out.println(s.solution(board, moves));
  }
}

class Solution {
  public int solution(int[][] board, int[] moves) {
    int answer = 0;
    ArrayList<Integer> basket = new ArrayList<Integer>();
    for (int move : moves) {
      for (int i = 0; i < board.length; ++i) {
        int val = board[i][move - 1];
        if (val != 0) {
          if (!basket.isEmpty() && basket.get(basket.size() - 1) == val) {
            basket.remove(basket.size() - 1);
            answer += 2;
          } else {
            basket.add(val);
          }
          board[i][move - 1] = 0;
          break;
        }
      }
    }

    return answer;
  }
}
