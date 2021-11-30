
/**
 * @author suho kim
 * @no 10699
 * @title 오늘 날짜
 * @url https://www.acmicpc.net/problem/10699
 * @date 2021.11.30
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
  public static void main(String[] args) {
    System.out.println((new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
  }
}
