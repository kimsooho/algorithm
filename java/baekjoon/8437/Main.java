
/**
 * @author suho kim
 * @no 8437
 * @title Julka 
 * @url https://www.acmicpc.net/problem/8437
 * @date 2021.12.14
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BigInteger total = new BigInteger(br.readLine());
    BigInteger diff = new BigInteger(br.readLine());

    System.out.println((total.subtract(diff)).divide(new BigInteger("2")).add(diff));
    System.out.println((total.subtract(diff)).divide(new BigInteger("2")));
  }
}
