
/**
 * @author suho kim
 * @no 1755
 * @title 숫자놀이
 * @url https://www.acmicpc.net/problem/1755
 * @date 2021.09.27
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Util {

  public static String toString(int num) {
    String strNum = String.valueOf(num);
    String[] nums = strNum.split("");
    String retValue = "";

    for (int i = 0; i < nums.length; ++i) {
      retValue += (parseNumString(nums[i])) + " ";
    }
    return retValue.trim();
  }

  private static String parseNumString(String num) {
    if (num.equals("0")) {
      return "zero";
    } else if (num.equals("1")) {
      return "one";
    } else if (num.equals("2")) {
      return "two";
    } else if (num.equals("3")) {
      return "thress";
    } else if (num.equals("4")) {
      return "four";
    } else if (num.equals("5")) {
      return "five";
    } else if (num.equals("6")) {
      return "six";
    } else if (num.equals("7")) {
      return "seven";
    } else if (num.equals("8")) {
      return "eight";
    } else if (num.equals("9")) {
      return "nine";
    }

    return "";
  }
}

class Alpha implements Comparable<Alpha> {
  int num;

  public Alpha(int num) {
    this.num = num;
  }

  @Override
  public int compareTo(Alpha o) {
    return Util.toString(this.num).compareTo(Util.toString(o.num));
  }
}

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    PriorityQueue<Alpha> pq = new PriorityQueue<Alpha>();
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    for (int i = M; i <= N; ++i) {
      pq.offer(new Alpha(i));
    }

    int count = 0;
    while (!pq.isEmpty()) {
      if (count != 0 && count % 10 == 0) {
        System.out.println();
      }
      System.out.print(pq.poll().num + " ");
      ++count;
    }
  }
}
