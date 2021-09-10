
/**
 * @author suho kim
 * @no 1100
 * @title 하얀 칸
 * @url https://www.acmicpc.net/problem/1100
 * @date 2021.09.10
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int count = 0;

    boolean whiteBoard = true;
    for (int i = 0; i < 8; ++i) {
      String line = br.readLine();
      for (int j = 0; j < line.length(); ++j) {

        if (whiteBoard && line.charAt(j) == 'F')
          ++count;
        whiteBoard = !whiteBoard;
      }
      whiteBoard = !whiteBoard;
    }
    System.out.println(count);
  }
}
