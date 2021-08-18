import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class BC
{
  int x;
  int y;
  int c;
  int value;
  public BC(int x, int y, int c, int value)
  {
    this.x = x;
    this.y = y;
    this.c = c;
    this.value = value;
  }
}

class User
{
  int x;
  int y;
  ArrayList<Integer> moveInfo;
  public User(int x, int y)
  {
    this.x = x;
    this.y = y;
    moveInfo = new ArrayList<Integer>();
    moveInfo.add(0);
  }
}

public class Solution {
  static int[] axisX = {0, 0, 1, 0, -1};
  static int[] axisY = {0, -1, 0, 1, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());

    for(int t=1; t<=T; ++t)
    {
      st = new StringTokenizer(br.readLine());
      int M = Integer.parseInt(st.nextToken());
      int A = Integer.parseInt(st.nextToken());

      User userA = new User(1, 1);
      User userB = new User(10, 10);
      
      ArrayList<BC> APs = new ArrayList<BC>();

      int sum = 0;
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<M; ++i)
      {
        userA.moveInfo.add(Integer.parseInt(st.nextToken()));
      }

      st = new StringTokenizer(br.readLine());
      for(int i=0; i<M; ++i)
      {
        userB.moveInfo.add(Integer.parseInt(st.nextToken()));
      }
      
      for(int i=0; i<A; ++i)
      {
        st = new StringTokenizer(br.readLine());
        APs.add(new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
      }

      for(int i=0; i<M+1; ++i)
      {
        userA.x += axisX[userA.moveInfo.get(i)];
        userA.y += axisY[userA.moveInfo.get(i)];

        userB.x += axisX[userB.moveInfo.get(i)];
        userB.y += axisY[userB.moveInfo.get(i)];
        
        int maxValue = 0;

        ArrayList<Boolean> validA = new ArrayList<Boolean>();
        ArrayList<Boolean> validB = new ArrayList<Boolean>();

        for(int ap=0; ap<A; ++ap)
        { 
          validA.add(isValid(userA, APs.get(ap)));
          validB.add(isValid(userB, APs.get(ap)));
        }

        for(int a=0; a<A; ++a)
        {
          for(int b=0; b<A; ++b)
          {
            int s = 0;
            if(validA.get(a) && validB.get(b) && a == b) // 겹칠 때
            {
              s = APs.get(a).value;
            }
            else{
              if(validA.get(a))
              {
                s += APs.get(a).value;
              }
              if(validB.get(b))
              {
                s += APs.get(b).value;
              }
            }
            maxValue = Math.max(maxValue, s);
          }
        }

        sum += maxValue;
      }

      System.out.println(String.format("#%d %d", t, sum));
    }
  }

  private static int getDistance(User user, BC bc)
  {
    return Math.abs(user.x - bc.x) + Math.abs(user.y - bc.y);
  }

  private static boolean isValid(User user, BC bc)
  {
    if(getDistance(user, bc) > bc.c) return false;

    return true;
  }
}
