import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int switchCount = sc.nextInt();

    int[] switchs = new int[switchCount + 1];

    for (int i = 1; i < switchs.length; ++i) {
      switchs[i] = sc.nextInt();
    }

    int studentsCount = sc.nextInt();

    for (int i = 0; i < studentsCount; ++i) {
      int gender = sc.nextInt();
      int switchNum = sc.nextInt();

      if (gender == 1) {
        int multiply = 2;
        int index = switchNum;
        while (index < switchs.length) {
          switchs[index] = (~switchs[index]) & 1;
          index = switchNum * multiply++;
        }
      } else {
        int start = switchNum - 1;
        int end = switchNum + 1;

        switchs[switchNum] = (~switchs[switchNum]) & 1;
        while (start > 0 && end < switchs.length && switchs[start] == switchs[end]) {
          switchs[start] = (~switchs[start--]) & 1;
          switchs[end] = (~switchs[end++]) & 1;
        }
      }
    }

    for (int i = 1; i < switchs.length; ++i) {
      if ((i - 1) % 20 == 0 && i != 1)
        System.out.println();
      System.out.print(switchs[i] + " ");
    }
  }
}
