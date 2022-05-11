
/**
 * @author suho kim
 * @no 92341
 * @title 주차 요금 계산
 * @url https://programmers.co.kr/learn/courses/30/lessons/92341
 * @date 2022.05.11
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
  public static void main(String[] args) {

  }
}

class Solution {
  public int[] solution(int[] fees, String[] records) {
    // fees / 기본시간 / 기본 요금 / 단위시간/ 단위요금
    int[] answer = {};
    HashMap<String, String> hash = new HashMap<String, String>();
    HashMap<String, Integer> hashTime = new HashMap<String, Integer>();
    for (int i = 0; i < records.length; ++i) {
      String time = records[i].split(" ")[0];
      String carNum = records[i].split(" ")[1];
      String type = records[i].split(" ")[2];

      if (!hashTime.containsKey(carNum)) {
        hashTime.put(carNum, 0);
      }

      if (!hash.containsKey(carNum)) {
        hash.put(carNum, time);
      } else {
        String inTime = hash.get(carNum);
        hash.remove(carNum);

        int timeDiff = getDiffMin(inTime, time);

        hashTime.replace(carNum, hashTime.get(carNum) + timeDiff);
      }
    }

    Set<String> s = hash.keySet();
    for (String key : s) {
      String time = hash.get(key);
      hashTime.replace(key, hashTime.get(key) + getDiffMin(time, "23:59"));
    }

    answer = new int[hashTime.size()];

    Set<String> set = hashTime.keySet();
    List<String> list = new ArrayList<String>(set);

    Collections.sort(list);

    for (int i = 0; i < list.size(); ++i) {
      int time = hashTime.get(list.get(i));
      answer[i] = time <= fees[0] ? fees[1] : fees[1] + (int) Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3];
    }

    return answer;
  }

  private int getDiffMin(String inTime, String outTime) {
    int inTimeHour = Integer.parseInt(inTime.split(":")[0]);
    int inTimeMin = Integer.parseInt(inTime.split(":")[1]);

    int outTimeHour = Integer.parseInt(outTime.split(":")[0]);
    int outTimeMin = Integer.parseInt(outTime.split(":")[1]);

    int timeDiff = 0;
    if (outTimeMin < inTimeMin) {
      timeDiff = 60 - inTimeMin + outTimeMin;
      ++inTimeHour;
      inTimeMin = 0;
      outTimeMin = 0;
    }
    timeDiff += ((outTimeHour - inTimeHour) * 60) + (outTimeMin - inTimeMin);

    return timeDiff;
  }
}