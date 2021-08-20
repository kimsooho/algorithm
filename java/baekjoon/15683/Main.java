/**
 * @author suho kim
 * @title 감시
 * @url https://www.acmicpc.net/problem/15683
 * @date 2021.08.20
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pair
{
  int x;
  int y;
  public Pair(int x, int y)
  {
    this.x = x;
    this.y = y;
  }
}

public class Main {
  static int N;
  static int M;

  static int[][] map;

  static int[] axisX = {1, 0, -1, 0};
  static int[] axisY = {0, -1, 0, 1};

  static ArrayList<Pair> pairs;

  static int minValue;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    pairs = new ArrayList<Pair>();

    minValue = Integer.MAX_VALUE;

    int[][] checkBoard = new int[N][M];

    for(int i=0; i<N; ++i)
    {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; ++j)
      {
        map[i][j] = Integer.parseInt(st.nextToken());
        checkBoard[i][j] = map[i][j];
        if(map[i][j] != 0 && map[i][j] != 6)
        {
          pairs.add(new Pair(j, i));
        }
      }
    }

    dfs(0, checkBoard);
    System.out.println(minValue);
  }

  private static void dfs(int idx, int[][] checkBoard)
  {
    if(idx == pairs.size())
    {
      minValue = Math.min(minValue, getNonDetectedCount(checkBoard));
      return;
    }

    Pair pair = pairs.get(idx);
    int y = pair.y;
    int x = pair.x;

    if(map[y][x] == 1)
    {
      for(int i=0; i<4; ++i)
      {
        int[][] checkBoardCopy = copyArray(checkBoard);  
        int nextY = y + axisY[i];    
        int nextX = x + axisX[i];
        while(true)
        {
          if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || map[nextY][nextX] == 6) break;
          checkBoardCopy[nextY][nextX] = -1;

          nextY += axisY[i];
          nextX += axisX[i];
        }
        dfs(idx + 1, checkBoardCopy);
      }
    }
    else if(map[y][x] == 2)
    {
      for(int i=0; i<2; ++i)
      {
        int[][] checkBoardCopy = copyArray(checkBoard);
        for(int j=i; j<4; j+=2)
        {
          int nextY = y + axisY[j];
          int nextX = x + axisX[j];
          while(true)
          {
            if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || map[nextY][nextX] == 6) break;
            checkBoardCopy[nextY][nextX] = -1;

            nextY += axisY[j];
            nextX += axisX[j];
          }
        }
        dfs(idx + 1, checkBoardCopy);
      }
    }
    else if(map[y][x] == 3)
    {
      for(int i=0; i<4; ++i)
      {
        int[][] checkBoardCopy = copyArray(checkBoard);
        for(int j=0; j<2; ++j)
        {
          int nextY = y + axisY[(i+j) % 4];
          int nextX = x + axisX[(i+j) % 4];

          while(true)
          {            
            if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || map[nextY][nextX] == 6) break;
            checkBoardCopy[nextY][nextX] = -1;

            nextY += axisY[(i+j) % 4];
            nextX += axisX[(i+j) % 4];
          }
        }
        dfs(idx + 1, checkBoardCopy);
      }
    }
    else if(map[y][x] == 4)
    {
      for(int i=0; i<4; ++i)
      {
        int[][] checkBoardCopy = copyArray(checkBoard);
        for(int j=0; j<4; ++j)
        {
          if(i==j) continue;
          int nextY = y + axisY[j];
          int nextX = x + axisX[j];

          while(true)
          {            
            if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || map[nextY][nextX] == 6) break;
            checkBoardCopy[nextY][nextX] = -1;

            nextY += axisY[j];
            nextX += axisX[j];
          }
        }
        dfs(idx + 1, checkBoardCopy);
      }
    }
    else if(map[y][x] == 5)
    {
      int[][] checkBoardCopy = copyArray(checkBoard);  
      for(int i=0; i<4; ++i)
      {
        int nextY = y + axisY[i];    
        int nextX = x + axisX[i];
        while(true)
        {
          if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || map[nextY][nextX] == 6) break;
          checkBoardCopy[nextY][nextX] = -1;

          nextY += axisY[i];
          nextX += axisX[i];
        }        
      }
      dfs(idx + 1, checkBoardCopy);
    }
  }

  private static int[][] copyArray(int[][] original)
  {
    int[][] copy = new int[N][M];  

    for(int i=0; i<N; ++i)
    {
      for(int j=0; j<M; ++j)
      {
        copy[i][j] = original[i][j];
      }
    }

    return copy;
  }

  private static int getNonDetectedCount(int[][] checkBoard)
  {
    int count = 0;
    for(int i=0; i<N; ++i)
    {
      for(int j=0; j<M; ++j)
      {
        if(checkBoard[i][j] == 0)
        {
          ++count;
        }
      }
    }
    return count;
  }
}
