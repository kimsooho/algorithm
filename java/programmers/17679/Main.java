
/**
 * @author suho kim
 * @no 17679
 * @title 프렌즈4블록
 * @url https://programmers.co.kr/learn/courses/30/lessons/17679
 * @date 2022.04.20
 */
import java.util.LinkedList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.solution(4, 5, new String[] { "CCBDE", "AAADE", "AAABF", "CCBBF" }));
    System.out.println(s.solution(6, 6, new String[] { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" }));
  }
}

class FriendsFourBlock {
  private char[][] board;
  private int width;
  private int height;

  private boolean hitable() {
    for (int i = 0; i < height - 1; ++i) {
      for (int j = 0; j < width - 1; ++j) {
        if (board[i][j] != '*' && board[i][j] == board[i + 1][j] && board[i][j] == board[i][j + 1] &&
            board[i][j] == board[i + 1][j + 1]) {
          return true;
        }
      }
    }
    return false;
  }

  private void hitBlock() {
    List<int[]> hitPositions = new LinkedList<int[]>();
    for (int i = 0; i < height - 1; ++i) {
      for (int j = 0; j < width - 1; ++j) {
        if (board[i][j] == board[i + 1][j] && board[i][j] == board[i][j + 1] &&
            board[i][j] == board[i + 1][j + 1]) {
          hitPositions.add(new int[] { i, j });
          hitPositions.add(new int[] { i + 1, j });
          hitPositions.add(new int[] { i, j + 1 });
          hitPositions.add(new int[] { i + 1, j + 1 });
        }
      }
    }

    for (int[] position : hitPositions) {
      int row = position[0];
      int col = position[1];

      board[row][col] = '*';
    }
  }

  private void dropBlock() {
    for (int i = height - 1; i >= 0; --i) {
      for (int j = 0; j < width; ++j) {
        if (board[i][j] == '*') {
          for (int k = i - 1; k >= 0; --k) {
            if (board[k][j] != '*') {
              board[i][j] = board[k][j];
              board[k][j] = '*';
              break;
            }
          }
        }
      }
    }
  }

  public void startGame() {
    while (hitable()) {
      hitBlock();
      dropBlock();
    }
  }

  public void initBlock(int m, int n, String[] board) {
    this.height = m;
    this.width = n;
    this.board = new char[height][width];

    for (int i = 0; i < height; ++i) {
      for (int j = 0; j < width; ++j) {
        this.board[i][j] = board[i].charAt(j);
      }
    }
  }

  public int getHitBlockCount() {
    int hitCount = 0;
    for (int i = 0; i < height; ++i) {
      for (int j = 0; j < width; ++j) {
        if (board[i][j] == '*') {
          ++hitCount;
        }
      }
    }
    return hitCount;
  }
}

class Solution {
  public int solution(int m, int n, String[] board) {
    FriendsFourBlock ffb = new FriendsFourBlock();
    ffb.initBlock(m, n, board);
    ffb.startGame();
    int answer = ffb.getHitBlockCount();
    return answer;
  }
}