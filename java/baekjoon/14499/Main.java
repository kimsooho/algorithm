
/**
 * @author suho kim
 * @no 주사위 굴리기
 * @title 14499
 * @url https://www.acmicpc.net/problem/14499
 * @date 2022.03.30
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Dice {
  int row;
  int col;

  int[] moveRow = { 0, 0, 0, -1, 1 };
  int[] moveCol = { 0, 1, -1, 0, 0 };

  int[] numbers = new int[6];

  public Dice(int row, int col) {
    this.row = row;
    this.col = col;
  }

  public void rotation(int direction) {
    int[] prevNumbers = numbers.clone();
    if (direction == 1) { // 동
      numbers[0] = prevNumbers[2];
      numbers[2] = prevNumbers[5];
      numbers[3] = prevNumbers[0];
      numbers[5] = prevNumbers[3];
    } else if (direction == 2) { // 서
      numbers[2] = prevNumbers[0];
      numbers[5] = prevNumbers[2];
      numbers[0] = prevNumbers[3];
      numbers[3] = prevNumbers[5];
    } else if (direction == 3) { // 북
      numbers[0] = prevNumbers[1];
      numbers[4] = prevNumbers[0];
      numbers[1] = prevNumbers[5];
      numbers[5] = prevNumbers[4];
    } else if (direction == 4) { // 남
      numbers[1] = prevNumbers[0];
      numbers[0] = prevNumbers[4];
      numbers[5] = prevNumbers[1];
      numbers[4] = prevNumbers[5];
    }
  }

  public boolean moveable(int direction, int n, int m) {
    int nextRow = moveRow[direction] + this.row;
    int nextCol = moveCol[direction] + this.col;
    if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) {
      return false;
    }

    this.row = nextRow;
    this.col = nextCol;
    return true;
  }

  public void printTopNumber() {
    System.out.println(numbers[5]);
  }

  public int getBottomNumber() {
    return numbers[0];
  }

  public void setBottomNumber(int n) {
    numbers[0] = n;
  }
}

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());
    int Y = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[][] map = new int[N][M];
    Dice dice = new Dice(X, Y);

    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < K; ++i) {
      int dir = Integer.parseInt(st.nextToken());
      if (dice.moveable(dir, N, M)) {
        dice.rotation(dir);
        if (map[dice.row][dice.col] == 0) {
          map[dice.row][dice.col] = dice.getBottomNumber();
        } else {
          dice.setBottomNumber(map[dice.row][dice.col]);
          map[dice.row][dice.col] = 0;
        }

        dice.printTopNumber();
      }
    }
  }
}
