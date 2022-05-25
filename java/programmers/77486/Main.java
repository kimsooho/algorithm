
/**
 * @author suho kim
 * @no 77486
 * @title 다단계 칫솔 판매
 * @url https://programmers.co.kr/learn/courses/30/lessons/77486
 * @date 2022.05.25
 */
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    s.solution(new String[] { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" },
        new String[] { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" },
        new String[] { "young", "john", "tod", "emily", "mary" },
        new int[] { 12, 4, 2, 5, 10 });

    s.solution(new String[] { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" },
        new String[] { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" },
        new String[] { "sam", "emily", "jaimie", "edward" },
        new int[] { 2, 3, 5, 4 });
  }
}

class Enroll {
  int amount;
  String referral;

  public Enroll(String referral) {
    this.referral = referral;
  }

  public void addAmount(int amount) {
    this.amount += amount;
  }
}

class Solution {
  Map<String, Enroll> hsEroll;

  public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    int[] answer = {};
    int enrollLength = enroll.length;
    int sellerLength = seller.length;
    hsEroll = new HashMap<>();
    for (int i = 0; i < enrollLength; ++i) {
      String enrollName = enroll[i];
      String referralName = referral[i];
      hsEroll.put(enrollName, new Enroll(referralName));
    }

    for (int i = 0; i < sellerLength; ++i) {
      int price = amount[i] * 100;
      String sellerName = seller[i];
      Enroll er = hsEroll.get(sellerName);
      String referralName = "";
      while (!referralName.equals("-")) {
        referralName = er.referral;
        if (price < 10) {
          er.addAmount(price);
          break;
        }

        int referralPrice = (int) (price * 0.1);

        er.addAmount(price - referralPrice);
        price = referralPrice;
        er = hsEroll.get(referralName);
      }
    }

    answer = new int[enrollLength];
    for (int i = 0; i < enrollLength; ++i) {
      String enrollName = enroll[i];
      answer[i] = hsEroll.get(enrollName).amount;
    }

    return answer;
  }
}