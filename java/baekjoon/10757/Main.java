
/**
 * @author suho kim
 * @no 10757
 * @title 큰 수 A+B
 * @url https://www.acmicpc.net/problem/10757
 * @date 2022.03.30
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    BigInteger bi = new BigInteger(st.nextToken());
    System.out.println(bi.add(new BigInteger(st.nextToken())));
  }
}
