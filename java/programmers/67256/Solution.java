import java.util.HashMap;

class Pair {
  int x;
  int y;

  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void setPos(Pair pair) {
    this.x = pair.x;
    this.y = pair.y;
  }
}

public class Solution {
  public String solution(int[] numbers, String hand) {
    String answer = "";

    HashMap<Integer, Pair> phone = new HashMap<Integer, Pair>();
    int number = 0;
    phone.put(number++, new Pair(1, 3));
    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 3; ++j) {
        phone.put(number++, new Pair(j, i));
      }
    }
    Pair left = new Pair(0, 3);
    Pair right = new Pair(2, 3);

    for (int i = 0; i < numbers.length; ++i) {
      Pair pairNumber = phone.get(numbers[i]);
      if (pairNumber.x == 0) {
        answer += "L";
        left.setPos(pairNumber);
      } else if (pairNumber.x == 2) {
        answer += "R";
        right.setPos(pairNumber);
      } else {
        int leftDistance = getDistance(left, pairNumber);
        int rightDistance = getDistance(right, pairNumber);
        if (leftDistance == rightDistance) {
          if (hand.equals("left")) {
            answer += "L";
            left.setPos(pairNumber);
          } else {
            answer += "R";
            right.setPos(pairNumber);
          }
        } else if (leftDistance < rightDistance) {
          answer += "L";
          left.setPos(pairNumber);
        } else {
          answer += "R";
          right.setPos(pairNumber);
        }
      }
    }

    return answer;
  }

  private int getDistance(Pair pair1, Pair pair2) {
    return Math.abs(pair1.x - pair2.x) + Math.abs(pair1.y - pair2.y);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] numbers = new int[] { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
    String hand = "right";
    System.out.println(s.solution(numbers, hand));
  }
}