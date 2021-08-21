
/**
 * @author suho kim
 * @no  1085
 * @title 직사각형에서 탈출
 * @url https://www.acmicpc.net/problem/1085
 * @date 2021.08.21
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    int h = Integer.parseInt(st.nextToken());

    System.out.println(Math.min(Math.min(x, y), Math.min(Math.abs(x - w), Math.abs(y - h))));
  }
}