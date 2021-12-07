import java.math.BigInteger;
/**
 * @author suho kim
 * @no 2338
 * @title 긴자리 계산
 * @url https://www.acmicpc.net/problem/2338
 * @date 2021.12.07
 */
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    BigInteger A = new BigInteger(sc.next());
    BigInteger B = new BigInteger(sc.next());
    System.out.println(A.add(B));
    System.out.println(A.subtract(B));
    System.out.println(A.multiply(B));
  }
}
