class Solution {
  public static int solution(int n, int[] lost, int[] reserve) {
    int answer = 0;

    int[] students = new int[n + 1];

    for (int i = 0; i < lost.length; ++i) {
      --students[lost[i]];
    }

    for (int i = 0; i < reserve.length; ++i) {
      ++students[reserve[i]];
    }

    for (int i = 1; i < students.length; ++i) {
      if (students[i] == -1) {
        if (i > 1 && students[i - 1] == 1) {
          students[i - 1] = 0;
          students[i] = 0;
        } else if (i + 1 < students.length && students[i + 1] == 1) {
          students[i + 1] = 0;
          students[i] = 0;
        }
      }
    }

    for (int i = 1; i < students.length; ++i) {
      if (students[i] != -1)
        ++answer;
    }

    return answer;
  }

  public static void main(String[] args) {
    //solution(3, new int[] { 1, 3 }, new int[] { 1, 2 });
  }
}