import java.util.Arrays;

class Pair implements Comparable<Pair> {
  int idx;
  double rate;

  public Pair(int idx) {
    this.idx = idx;
    this.rate = 0.0;
  }

  @Override
  public int compareTo(Pair o) {
    if (this.rate == o.rate)
      return this.idx - o.idx;

    return Double.compare(o.rate, this.rate);
  }
}

class Solution {
  public int[] solution(int N, int[] stages) {
    int[] answer = new int[N];
    int[] failCount = new int[N + 1];
    Pair[] rate = new Pair[N + 1];

    for (int i = 0; i < N + 1; ++i) {
      rate[i] = new Pair(i);
    }

    int l = stages.length;
    Arrays.sort(stages);

    for (int i = 0; i < stages.length; ++i) {
      if (stages[i] <= N)
        ++failCount[stages[i]];
    }

    for (int i = 1; i < N + 1 && l > 0; ++i) {
      rate[i].rate = (double) failCount[i] / l;
      l -= failCount[i];
    }

    Arrays.sort(rate);
    int idx = 0;
    for (int i = 0; i < N + 1; ++i) {
      if (rate[i].idx != 0) {
        answer[idx++] = rate[i].idx;
        System.out.println(rate[i].idx + ", " + rate[i].rate);
      }
    }
    System.out.println(Arrays.toString(failCount));

    return answer;
  }
}