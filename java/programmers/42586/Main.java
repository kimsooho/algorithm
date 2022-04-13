
/**
 * @author suho kim
 * @no 42586
 * @title 기능개발
 * @url https://programmers.co.kr/learn/courses/30/lessons/42586
 * @date 2022.04.13
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(Arrays.toString(s.solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 })));
    System.out
        .println(Arrays.toString(s.solution(new int[] { 95, 90, 99, 99, 80, 99 }, new int[] { 1, 1, 1, 1, 1, 1 })));
  }
}

class Progress {
  private int progress;
  private int speed;

  public Progress(int progress, int speed) {
    this.progress = progress;
    this.speed = speed;
  }

  public void setProgress(int progress) {
    this.progress = progress;
  }

  public void work(int minute) {
    progress += (speed * minute);
    if (progress > 100)
      progress = 100;

  }

  public int getNeedMinute() {
    if ((100 - progress) % speed == 0)
      return (100 - progress) / speed;

    return ((100 - progress) / speed) + 1;
  }

  public boolean isFinished() {
    return progress == 100;
  }
}

class Solution {
  public int[] solution(int[] progresses, int[] speeds) {
    int[] answer = {};
    List<Integer> listAnswer = new ArrayList<Integer>();
    int arrSize = progresses.length;
    Queue<Progress> qProgresses = new LinkedList<Progress>();
    for (int i = 0; i < arrSize; ++i) {
      qProgresses.offer(new Progress(progresses[i], speeds[i]));
    }

    while (!qProgresses.isEmpty()) {
      int qSize = qProgresses.size();
      int minute = qProgresses.peek().getNeedMinute();

      int finishedCount = 0;
      for (int i = 0; i < qSize; ++i) {
        Progress progress = qProgresses.poll();
        progress.work(minute);
        qProgresses.offer(progress);
      }

      for (int i = 0; i < qSize; ++i) {
        Progress progress = qProgresses.peek();
        if (!progress.isFinished())
          break;

        qProgresses.poll();
        ++finishedCount;
      }
      listAnswer.add(finishedCount);
    }

    answer = listAnswer.stream().mapToInt(i -> i).toArray();

    return answer;
  }
}